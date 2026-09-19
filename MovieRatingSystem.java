import java.util.Scanner;

public class MovieRatingSystem {

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the user's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("\nWelcome, " + name + "!");
        System.out.println("Let's review five movies you recently watched.\n");

        // Step 2: Create parallel arrays for movie names and ratings
        String[] movies = new String[5];
        int[] ratings = new int[5];

        // Ask for five movies and validate each rating
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the name of movie " + (i + 1) + ": ");
            movies[i] = scanner.nextLine();

            // Keep asking until a valid rating from 1-10 is entered
            while (true) {
                System.out.print("Rate \"" + movies[i] + "\" from 1 to 10: ");

                if (scanner.hasNextInt()) {
                    int rating = scanner.nextInt();

                    if (rating >= 1 && rating <= 10) {
                        ratings[i] = rating;
                        scanner.nextLine(); // Consume leftover newline
                        break;
                    } else {
                        System.out.println("Invalid rating. Please enter a number from 1 to 10.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a whole number from 1 to 10.");
                    scanner.nextLine(); // Clear invalid input
                }
            }

            System.out.println();
        }

        // Step 3: Calculate the average rating
        int totalRating = 0;

        for (int rating : ratings) {
            totalRating += rating;
        }

        double averageRating = (double) totalRating / ratings.length;

        System.out.printf("Your average movie rating is: %.2f%n", averageRating);

        // Step 4: Classify the user's overall movie taste
        if (averageRating >= 9) {
            System.out.println("You are a cinephile!");
        } else if (averageRating >= 7) {
            System.out.println("You enjoy movies quite a bit.");
        } else if (averageRating >= 5) {
            System.out.println("You have mixed feelings about movies.");
        } else {
            System.out.println("You are a tough critic!");
        }

        // Step 5: Check for favorite/masterpiece and poorly rated movies
        boolean hasMasterpiece = false;
        boolean hasLowRatedMovie = false;

        for (int rating : ratings) {
            if (rating == 10) {
                hasMasterpiece = true;
            }

            if (rating < 4) {
                hasLowRatedMovie = true;
            }
        }

        // Nested if statements
        if (hasMasterpiece) {
            if (hasLowRatedMovie) {
                System.out.println("Wow! You found a masterpiece.");
                System.out.println("That movie didn't impress you much.");
            } else {
                System.out.println("Wow! You found a masterpiece.");
            }
        } else if (hasLowRatedMovie) {
            System.out.println("That movie didn't impress you much.");
        }

        // Step 6: Use logical operators to identify consistent ratings
        boolean allSevenOrHigher = true;

        for (int rating : ratings) {
            if (!(rating >= 7)) {
                allSevenOrHigher = false;
            }
        }

        if (allSevenOrHigher && ratings.length == 5) {
            System.out.println("You seem to enjoy most movies.");
        } else {
            boolean veryLowRating = false;

            for (int rating : ratings) {
                if (rating < 3 || rating == 1) {
                    veryLowRating = true;
                }
            }

            if (veryLowRating) {
                System.out.println("You have strong opinions on movies!");
            }
        }

        // Step 7: Ask for favorite genre
        System.out.println("\nChoose your favorite movie genre:");
        System.out.println("1. Action");
        System.out.println("2. Comedy");
        System.out.println("3. Horror");
        System.out.println("4. Drama");
        System.out.println("5. Sci-Fi");

        System.out.print("Enter your choice: ");
        String genreChoice = scanner.nextLine().trim().toLowerCase();

        String genre;

        switch (genreChoice) {
            case "1":
            case "action":
                genre = "Action";
                System.out.println("You love excitement and thrills!");
                break;

            case "2":
            case "comedy":
                genre = "Comedy";
                System.out.println("You enjoy a good laugh.");
                break;

            case "3":
            case "horror":
                genre = "Horror";
                System.out.println("You have a taste for fear!");
                break;

            case "4":
            case "drama":
                genre = "Drama";
                System.out.println("You appreciate deep storytelling.");
                break;

            case "5":
            case "sci-fi":
            case "scifi":
                genre = "Sci-Fi";
                System.out.println("You love futuristic and imaginative worlds!");
                break;

            default:
                genre = "Other";
                System.out.println("That's an interesting genre choice!");
                break;
        }

        // Step 8: Conditional operator for movie recommendation
        String recommendation = genre.equals("Sci-Fi")
                ? "Interstellar"
                : "The Dark Knight";

        System.out.println("\nBased on your favorite genre, we recommend: "
                + recommendation);

        // Display a summary
        System.out.println("\n----- Movie Rating Summary -----");
        System.out.println("Reviewer: " + name);

        for (int i = 0; i < movies.length; i++) {
            System.out.println(movies[i] + " - " + ratings[i] + "/10");
        }

        System.out.printf("Average Rating: %.2f/10%n", averageRating);
        System.out.println("Favorite Genre: " + genre);
        System.out.println("Recommended Movie: " + recommendation);

        // Close Scanner
        scanner.close();
    }
}
