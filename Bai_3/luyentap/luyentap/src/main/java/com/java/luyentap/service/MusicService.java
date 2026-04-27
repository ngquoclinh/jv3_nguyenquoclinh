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
}
