package com.sabrouch.movie_catalog.ressource;

import com.sabrouch.movie_catalog.module.CatlogMovie;
import com.sabrouch.movie_catalog.module.Movie;
import com.sabrouch.movie_catalog.module.Rating;
import com.sabrouch.movie_catalog.module.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalog {

    private final RestTemplate restTemplate;
  //private final WebClient.Builder webClientBuilder;
    public MovieCatalog(RestTemplate restTemplate, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
    }


    @RequestMapping("/{userId}")
    public List<CatlogMovie> getCatalog(@PathVariable String userId) {
        //get all movie

/*
        List<Rating> rating = Arrays.asList(
                new Rating("123", 4),
                new Rating("13", 3),
                new Rating("1234", 5)

        );
        */
//singletonList return immutable List serializable
        UserRating  rating = restTemplate.getForObject("http://localhost:8081/rate/user" +userId,
                UserRating.class);

        return rating.getUserRating().stream()
                .map(rating1 -> { Movie movie = restTemplate.getForObject("http://localhost:8082/info/1" + rating1.getMovieId(), Movie.class);

                            return new CatlogMovie(movie.getName(), "desc", rating1.getRating());

                        }


                )
                .collect(Collectors.toList());
    }


}
