# MovieRecommendation
This program recommends movies based on the user's liked actors and genres. It uses a similarity score calculated from the user's inputs and the movie's cast and genres to determine the recommended movies.

## Usage
The user is prompted to enter a comma-separated list of their liked actors and genres. The program reads in a JSON file of movies, and then recommends movies based on the user's input.

## Dependencies
Jackson Core Library 2.13.0
Jackson Databind Library 2.13.0

## JSON Data Format
The JSON data should be an array of movie objects, each with the following properties:
-title (string)
-cast (array of strings)
-genres (array of strings)
-releaseYear (integer) 

## Example

```[
    {
        "title": "The Shawshank Redemption",
        "cast": ["Tim Robbins", "Morgan Freeman", "Bob Gunton"],
        "genres": ["Drama"],
        "releaseYear": 1994
    },
    {
        "title": "The Godfather",
        "cast": ["Marlon Brando", "Al Pacino", "James Caan"],
        "genres": ["Crime", "Drama"],
        "releaseYear": 1972
    },
    ...
]
