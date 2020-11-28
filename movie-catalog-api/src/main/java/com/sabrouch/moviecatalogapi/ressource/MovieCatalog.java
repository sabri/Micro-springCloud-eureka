package com.sabrouch.moviecatalogapi.ressource;


import com.sabrouch.moviecatalogapi.module.CatlogMovie;
import com.sabrouch.moviecatalogapi.module.Movie;
import com.sabrouch.moviecatalogapi.module.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


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
        UserRating rating = restTemplate.getForObject("http://localhost:8086/rate/user" +userId,
                UserRating.class);

        return rating.getUserRating().stream()
                .map(rating1 -> { Movie movie = restTemplate.getForObject("http://localhost:8087/info/1" + rating1.getMovieId(), Movie.class);

                            return new CatlogMovie(movie.getName(), "desc", rating1.getRating());

                        }


                )
                .collect(Collectors.toList());
    }


}
