package com.java.luyentap.service;

import com.java.luyentap.model.Music;
import com.java.luyentap.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    @Autowired
    MusicRepository musicRepository;

    public List<Music> getAllMusics() {
        return musicRepository.findAll();
    }

    public List<Music> findByArtist(String artist) {
        return musicRepository.findByArtist(artist);
    }

    public List<Music> findByYearAndTitle(Integer year, String title) {
        return musicRepository.findByYearAndTitle(year, title);
    }

    public List<Music> findByRatingGreaterThan(Double rating) {
        return musicRepository.findByRatingGreaterThan(rating);
    }

    public List<Music> findByRatingLessThanEqual(Double rating) {
        return musicRepository.findByRatingLessThanEqual(rating);
    }

    public List<Music> findByYearBetween(Integer startYear, Integer endYear) {
        return musicRepository.findByYearBetween(startYear, endYear);
    }

    public List<Music> searchByKeyword(String keyString) {
        return musicRepository.findByTitleContainingIgnoreCase(keyString);
    }

}
