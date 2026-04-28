package com.java.luyentap.controller;

import com.java.luyentap.model.Music;
import com.java.luyentap.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @Autowired
    private org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;

    @GetMapping("/debug")
    public Object debug() {
        return mongoTemplate.getDb().getName();
    }


    @GetMapping("/get-all")
    public ResponseEntity<List<Music>> getAllMusics() {
        List<Music> musics =  musicService.getAllMusics();
        return new ResponseEntity<List<Music>>(musics, HttpStatus.OK);
    }

    @GetMapping("/get-by-artist/{artist}") // /api/v1/music/get-by-artist/Pink%20Floyd
    public List<Music> getByArtist(@PathVariable("artist") String artist) {
        return musicService.findByArtist(artist);
    }

    @GetMapping("/get-by-year-title/{year}/{title}") // /api/v1/music/get-by-year-title/2013/Random%20Access%20Memories
    public List<Music> getByYearAndTitle(
            @PathVariable("year") Integer year,
            @PathVariable("title") String title
    ) {
        return musicService.findByYearAndTitle(year, title);
    }

    @GetMapping("/get-by-rating-greater-than/{rating}") // /api/v1/music/get-by-rating-greater-than/9.4
    public List<Music> getByRatingGreaterThan(@PathVariable("rating") Double rating) {
        return musicService.findByRatingGreaterThan(rating);
    }

    @GetMapping("/get-by-rating-less-than-equal/{rating}") // /api/v1/music/get-by-rating-less-than-equal/9.4
    public List<Music> getByRatingLessThanEqual(@PathVariable("rating") Double rating) {
        return musicService.findByRatingLessThanEqual(rating);
    }

    @GetMapping("/get-by-year-between/{startYear}/{endYear}") // /api/v1/music/get-by-year-between/1997/2006
    public List<Music> getByYearBetween(
            @PathVariable("startYear") Integer startYear,
            @PathVariable("endYear") Integer endYear
    ) {
        return musicService.findByYearBetween(startYear,endYear);
    }

    @GetMapping("/music/search")
    public ResponseEntity<List<Music>> searchByKeyword(@RequestParam String keyword) {
        List<Music> music = musicService.searchByKeyword(keyword);
        return new ResponseEntity<List<Music>>(music, HttpStatus.OK);
    }

}
