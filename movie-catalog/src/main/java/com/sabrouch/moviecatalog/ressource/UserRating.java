package com.sabrouch.moviecatalog.ressource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by sabrouch.
 * Date: 11/16/2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRating {
    private String userId;
    private List<Rating> userRating;
}
