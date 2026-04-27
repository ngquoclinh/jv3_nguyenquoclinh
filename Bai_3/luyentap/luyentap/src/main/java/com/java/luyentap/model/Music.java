package com.java.luyentap.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "musics")
public class Music {
    @Id
    private String id;
    private String title;
    private Integer year;
    private List<String> genre;
    private String artist;
    private Double rating;
}
