package hu.progmatic;

import java.util.Objects;

public class Movie {
    private String title;
    private String originalTitle;
    private String genre;
    private int madeYear;
    private String manufacturer;
    private String producer;
    private String actor;
    private String ageLimit;

    public Movie() {
    }

    public Movie(String title, String originalTitle, String genre, int madeYear, String manufacturer, String producer, String actor, String ageLimit) {
        this.title = title;
        this.originalTitle = originalTitle;
        this.genre = genre;
        this.madeYear = madeYear;
        this.manufacturer = manufacturer;
        this.producer = producer;
        this.actor = actor;
        this.ageLimit = ageLimit;
    }
    public Movie(String line){
        String[] parts = line.split(";");
        String[] actors = parts[6].split(" ");
        this.title = parts[0];
        this.originalTitle = parts[1];
        this.genre = parts[2];
        this.madeYear = Integer.parseInt(parts[3]);
        this.manufacturer = parts[4];
        this.producer = parts[5];
        this.actor = parts[6];
        this.ageLimit = parts[7];
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMadeYear() {
        return madeYear;
    }

    public void setMadeYear(int madeYear) {
        this.madeYear = madeYear;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    @Override
    public String toString() {
        return title + ", " + originalTitle + ", " + genre + ", " + madeYear + ", " + manufacturer + ", " + producer + ", " + actor + ", " + ageLimit + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return madeYear == movie.madeYear && title.equals(movie.title) && originalTitle.equals(movie.originalTitle) && manufacturer.equals(movie.manufacturer) && producer.equals(movie.producer) && actor.equals(movie.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, originalTitle, madeYear, manufacturer, producer, actor);
    }
}
