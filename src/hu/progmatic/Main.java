package hu.progmatic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        try {
            List<Movie> movies = loadMovies("src/hu/progmatic/FilmAdatbázisFormázott.csv");

            System.out.println("Number of movies: " + movies.size());
            System.out.println(searchByName(movies, "kiskutya"));

            System.out.println(totalMoviesByGenreCounter(movies));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Movie> loadMovies(String path) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    Movie movie = new Movie(line);
                    movies.add(movie);
                } catch (Exception e) {
                }
            }
        }
        return movies;
    }
    public static List<Movie> searchByName(List<Movie> movies, String title){
        List<Movie> chosenMovies = new ArrayList<>();
        for(Movie movie : movies){
            if(movie.getTitle().contains(title)){
                chosenMovies.add(movie);
            }
        }
        return chosenMovies;
    }
    public static Map<String, Integer> totalMoviesByGenreCounter(List<Movie> movies){
        Map<String, Integer> totalMoviesByGenre = new TreeMap<>();
        for (Movie movie : movies){
            int total = totalMoviesByGenre.getOrDefault(movie.getGenre(), 0) + 1;
            totalMoviesByGenre.put(movie.getGenre(), total);
        }
        return totalMoviesByGenre;
    }
}
