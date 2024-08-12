package org.example.dao;

import org.example.Singer;

import java.util.List;

public interface SingerDao {
    List<org.example.Singer> findAll();
    List<org.example.Singer> findByFirstName(String firstName);
    String findNameById(Long id);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(Singer singer);
    void update(Singer singer);
    void delete(Long singerId);
    List<Singer> findAllWithAlbums();
    void insertWithAlbum(Singer singer);
}
