package hu.progmatic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {

            List<Movie> movies = loadMovies("src/hu/progmatic/FilmAdatbázisFormázott.csv");

            System.out.println("Number of movies: " + movies.size());

            System.out.println(searchByName(movies, "2012"));

            System.out.println(totalMoviesByGenreCounter(movies));

            System.out.print("A legöregebb film az adatbázisban: ");
            System.out.print(mostOldMovie(movies));

            System.out.println(searchByMadeYear(movies, 2010));

            System.out.println(searchByProducer(movies, "Robert wise"));

            System.out.println(searchByActor(movies, "George Clooney"));


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
            int total = totalMoviesByGenre.getOrDefault(movie.getGenre(), 0);
            totalMoviesByGenre.put(movie.getGenre(), total + 1);
        }
        return totalMoviesByGenre;
    }
    public static Movie mostOldMovie(List<Movie> movies){
        Movie oldestMovie = new Movie();
        int oldest = Integer.MAX_VALUE;
        for (Movie movie : movies){
            if(movie.getMadeYear() < oldest){
                oldest = movie.getMadeYear();
                oldestMovie = movie;
            }
        }
        return oldestMovie;
    }
    public static List<Movie> searchByMadeYear(List<Movie> movies, int chosenYear){
        List<Movie> chosenMovies = new ArrayList<>();
        for (Movie movie : movies){
            if(movie.getMadeYear() == chosenYear){
                chosenMovies.add(movie);
            }
        }
        return chosenMovies;
    }
    public static List<Movie> searchByProducer(List<Movie> movies, String name){
        List<Movie> chosenMovies = new ArrayList<>();
        for (Movie movie : movies){
            if(movie.getProducer().equalsIgnoreCase(name)){
                chosenMovies.add(movie);
            }
        }
        return chosenMovies;
    }
    public static List<Movie> searchByActor(List<Movie> movies, String name){
        List<Movie> chosenMovies = new ArrayList<>();
        for (Movie movie : movies){
            if(movie.getActor().contains(name)){
                chosenMovies.add(movie);
            }
        }
        return chosenMovies;
    }
}
