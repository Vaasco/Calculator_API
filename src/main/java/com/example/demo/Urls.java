package com.example.demo;

/**
 * A class to centralize and manage URL paths for the calculator API.
 * This helps avoid hardcoding URLs throughout the application.
 */
public class Urls {

    // Base URL for the API, used to group common parts of the paths.
    private static final String BASE_URL = "/api";

    // URL path for the "sum" operation endpoint.
    public static final String PATH_SUM = BASE_URL + "/calculator/sum";

    // URL path for the "subtract" operation endpoint.
    public static final String PATH_SUBTRACT = BASE_URL + "/calculator/subtract";

    // URL path for the "multiply" operation endpoint.
    public static final String PATH_MULTIPLY = BASE_URL + "/calculator/multiply";

    // URL path for the "divide" operation endpoint.
    public static final String PATH_DIVIDE = BASE_URL + "/calculator/divide";
}
