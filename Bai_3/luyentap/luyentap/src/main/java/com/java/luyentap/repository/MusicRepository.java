package com.java.luyentap.repository;

import com.java.luyentap.model.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MusicRepository extends MongoRepository<Music, String> {
    List<Music> findAll();
    List<Music> findByArtist(String artist);
    List<Music> findByYearAndTitle(Integer year, String title);

}


