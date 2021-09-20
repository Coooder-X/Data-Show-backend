package com.datashow.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {
    private String content;
    private String title;
    private Long id;
}
