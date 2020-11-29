package com.sabrouch.moviecatalog.ressource;



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
    public MovieCatalog(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @RequestMapping("/{userId}")
    public List<CatlogMovie> getCatalog(@PathVariable("userId") String userId) {
        //get all movie

/*
        List<Rating> rating = Arrays.asList(
                new Rating("123", 4),
                new Rating("13", 3),
                new Rating("1234", 5)

        );
        */
//singletonList return immutable List serializable
        UserRating ratings = restTemplate.getForObject("http://RATE-MOVIE-API/rate/users/" + userId, UserRating.class);

        return ratings.getUserRating()
                .stream()
                .map(rating -> { Movie movie = restTemplate.getForObject("http://MOVIE-INFO-API/info/" +rating.getMovieId(), Movie.class);

                            return new CatlogMovie(movie.getName(), "desc", rating.getRating());

                        }


                )
                .collect(Collectors.toList());
    }
/*
Alternative WebClient way
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/

}
