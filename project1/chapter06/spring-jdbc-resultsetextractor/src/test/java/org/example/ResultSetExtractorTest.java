package org.example;

import org.example.config.NamedJdbcCfg;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ResultSetExtractorTest {
    @Test
    public void testResultSetExtractor() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcCfg.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
        List<Singer> singers = singerDao.findAllWithAlbums();
        assertTrue(singers.size() == 3);
        singers.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("\t--> " + album);
                }
                if (singer.getId() == 1L) {
                    assertTrue(singer.getAlbums().size() == 2);
                } else if (singer.getId() == 2L) {
                    assertTrue(singer.getAlbums().size() == 1);
                } else if (singer.getId() == 3L) {
                    assertTrue(singer.getAlbums().size() == 0);
                }
            }
        });
        ctx.close();
    }
}
