package com.rizkyfadillah.popularmoviesstage1.ui.detail;

import com.rizkyfadillah.popularmoviesstage1.vo.Movie;
import com.rizkyfadillah.popularmoviesstage1.repository.MovieRepository;
import com.rizkyfadillah.popularmoviesstage1.vo.Video;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * @author Rizky Fadillah on 17/07/2017.
 */

public class DetailViewModel {

    private MovieRepository movieRepository;

    public DetailViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    Observable<Boolean> addFavoriteMovie(Movie movie) {
        return movieRepository.addFavoriteMovie(movie)
                .map(new Function<Long, Boolean>() {
                    @Override
                    public Boolean apply(@NonNull Long aLong) throws Exception {
                        return aLong != -1;
                    }
                });
    }

    Observable<Video> getMovieVideos(String id) {
        return movieRepository.getMovieVideos(id);
    }

}