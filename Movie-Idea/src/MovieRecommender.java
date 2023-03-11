import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class MovieRecommender {
    private List<Movie> movies;

    public MovieRecommender(String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(jsonFilePath);
        movies = objectMapper.readValue(jsonFile, new TypeReference<List<Movie>>(){});
    }

    public List<Movie> recommendMovies(List<String> likedActors, List<String> likedGenres) {
        Set<String> actors = new HashSet<>(likedActors);
        Set<String> genres = new HashSet<>(likedGenres);

        List<Movie> recommendedMovies = new ArrayList<>();

        for (Movie movie : movies) {
            double similarityScore = calculateSimilarityScore(movie, actors, genres);

            if (similarityScore > 0) {
                recommendedMovies.add(movie);
            }
        }

        recommendedMovies.sort((m1, m2) -> Double.compare(calculateSimilarityScore(m2, actors, genres),
                calculateSimilarityScore(m1, actors, genres)));

        return recommendedMovies;
    }

    private double calculateSimilarityScore(Movie movie, Set<String> likedActors, Set<String> likedGenres) {
        Set<String> movieActors = new HashSet<>(movie.getCast());
        Set<String> movieGenres = new HashSet<>(movie.getGenres());

        double actorSimilarity = calculateSetSimilarity(movieActors, likedActors);
        double genreSimilarity = calculateSetSimilarity(movieGenres, likedGenres);

        return (actorSimilarity + genreSimilarity) / 2;
    }
    private double calculateSetSimilarity(Set<String> set1, Set<String> set2) {
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / (double) union.size();
    }
    public static String[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Beğendiğiniz aktörleri ve kategorileri virgülle ayırarak girin: ");
        String userInput = scanner.nextLine();
        return userInput.split(",");
    }

}
