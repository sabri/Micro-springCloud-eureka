package com.example.ratemovieapi.model;

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
    private List<Rating> userRating;
}
