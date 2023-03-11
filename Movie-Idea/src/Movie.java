import java.util.List;
public class Movie {
    private String title;
    private int year;
    private List<String> cast;
    private List<String> genres;

    public Movie() {}

    public Movie(String title, int year, List<String> cast, List<String> genres) {
        this.title = title;
        this.year = year;
        this.cast = cast;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getCast() {
        return cast;
    }

    public List<String> getGenres() {
        return genres;
    }
}
