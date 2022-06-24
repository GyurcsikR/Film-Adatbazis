package hu.progmatic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Movie> movies = loadMovies("src/hu/progmatic/FilmAdatbázisFormázott.csv");

            System.out.println("Number of movies: " + movies.size());
            System.out.println(searchByName(movies, "kiskutya"));

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
}
