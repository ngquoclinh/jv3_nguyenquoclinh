package com.java.luyentap.repository;

import com.java.luyentap.model.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MusicRepository extends MongoRepository<Music, String> {
    List<Music> findAll();
    List<Music> findByArtist(String artist);
    List<Music> findByYearAndTitle(Integer year, String title);
    List<Music> findByRatingGreaterThan(Double rating);
    List<Music> findByRatingLessThanEqual(Double rating);
    List<Music> findByYearBetween(Integer startYear, Integer endYear);
    List<Music> findByTitleContainingIgnoreCase(String keyword);
}


