package com.sabrouch.movie_catalog.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatlogMovie {

    private String name;
    private String desc;
    private int rating;


}
