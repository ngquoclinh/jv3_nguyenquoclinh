package com.java.luyentap.controller;

import com.java.luyentap.model.Music;
import com.java.luyentap.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
