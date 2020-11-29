package com.example.ratemovieapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
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

    public void initData(String userId) {
        this.setUserId(userId);
        this.setUserRating(Arrays.asList(
                new Rating("100", 3),
                new Rating("200", 4)
        ));
    }
}
