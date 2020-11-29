package com.example.movieinfoapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sabrouch.
 * Date: 11/29/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieSummary {
    private String id;
    private String title;
    private String overview;
}
