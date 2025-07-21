import java.util.*;

public class RecommendationSystem {
    public static void main(String[] args) {
        // Sample data
        Map<String, List<String>> userPreferences = new HashMap<>();
        userPreferences.put("Steve", Arrays.asList("Action", "Comedy"));
        userPreferences.put("John", Arrays.asList("Drama", "Romance"));

        Map<String, List<String>> movieGenres = new HashMap<>();
        movieGenres.put("Movie1", Arrays.asList("Action"));
        movieGenres.put("Movie2", Arrays.asList("Comedy"));
        movieGenres.put("Movie3", Arrays.asList("Drama"));
        movieGenres.put("Movie4", Arrays.asList("Action", "Comedy"));

        String currentUser = "Steve";
        List<String> preferences = userPreferences.get(currentUser);

        System.out.println("Recommendations for " + currentUser + ":");
        for (Map.Entry<String, List<String>> entry : movieGenres.entrySet()) {
            for (String genre : entry.getValue()) {
                if (preferences.contains(genre)) {
                    System.out.println("- " + entry.getKey() + " (" + genre + ")");
                    break;
                }
            }
        }
    }
}
