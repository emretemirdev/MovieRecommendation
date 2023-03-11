import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] userInputArray = getUserInput();
        List<String> likedActors = Arrays.asList(userInputArray[0].split(","));
        List<String> likedGenres = Arrays.asList(userInputArray[1].split(","));

        try {
            MovieRecommender movieRecommender = new MovieRecommender("movies.json");
            List<Movie> recommendedMovies = movieRecommender.recommendMovies(likedActors, likedGenres);

            System.out.println("Recommended Movies:");
            for (Movie movie : recommendedMovies) {
                System.out.println(movie.getTitle());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
        }
    }

    public static String[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Beğendiğiniz aktörleri ve kategorileri virgülle ayırarak girin: ");
        String userInput = scanner.nextLine();
        return userInput.split(",");
    }
}
