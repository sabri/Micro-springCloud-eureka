package com.sabrouch.moviecatalog.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private String movieId;
    private String name;
    private String desc;

}
