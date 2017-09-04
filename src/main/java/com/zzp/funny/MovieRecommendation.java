package com.zzp.funny;

import java.util.*;

class Movie {
    private int movieId;
    private float rating;
    private ArrayList<Movie> similarMovies;

    public Movie(int movieId, float rating) {
    }

    public int getId() {
        return movieId;
    }

    public float getRating() {
        return rating;
    }

    public List<Movie> getSimilarMovies() {
        return new ArrayList<>();
    }
}

class SortByRating implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        if (m1.getRating() >= m2.getRating()) {
            return 1;
        }
        return -1;
    }
}

public class MovieRecommendation {
    Set<Integer> visitedMovieIds = new HashSet<>();
    TreeSet<Movie> movies = new TreeSet<>(new SortByRating());

    void visitMovie(Movie movie, int N) {
        if (visitedMovieIds.contains(movie.getId())) {
            return;
        }

        visitedMovieIds.add(movie.getId());
        movies.add(movie);

        for (int i = 0; i < movie.getSimilarMovies().size(); i++) {
            Movie similarMovie = movie.getSimilarMovies().get(i);
            visitMovie(similarMovie, N);
        }
    }

    Set<Movie> getMovies(Movie movie, int N) {
        visitedMovieIds.add(movie.getId());

        for (int i = 0; i < movie.getSimilarMovies().size(); i++) {
            Movie similarMovie = movie.getSimilarMovies().get(i);
            visitMovie(similarMovie, N);
        }

        Set<Movie> result = new HashSet<>();
        for (Movie tmpMovie : movies) {
            if (result.size() < N) {
                result.add(tmpMovie);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
