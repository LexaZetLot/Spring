package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "album")
public class Album implements Serializable {
    private Long id;
    private String title;
    private Date releaseDate;
    private Singer singer;
    private int version;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId(){
        return this.id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion(){
        return version;
    }

    @Column
    public String getTitle(){
        return this.title;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    public Date getReleaseDate(){
        return this.releaseDate;
    }

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    public Singer getSinger(){
        return this.singer;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setSinger(Singer singer){
        this.singer = singer;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString(){
        return "Album - Id: " + id + ", Singer id: " + singer.getId()
                + ", Title: " + title + ", Release Dare: " + releaseDate;
    }
}
