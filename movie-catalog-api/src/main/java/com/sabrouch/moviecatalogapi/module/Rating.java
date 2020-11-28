package com.sabrouch.moviecatalogapi.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sabrouch.
 * Date: 11/13/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    private String movieId;
    private int rating;
}
