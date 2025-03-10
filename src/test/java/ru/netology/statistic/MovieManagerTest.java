package ru.netology.statistic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    @Test
    void testAddOneMovie() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Фильм 1");

        String[] expected = {"Фильм 1"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void testAddMultipleMovies() {

        MovieManager manager = new MovieManager();

        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");

        String[] expected = {"Фильм 1", "Фильм 2", "Фильм 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void testFindAllWithMultipleMovies() {

        MovieManager manager = new MovieManager();
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");


        String[] result = manager.findAll();


        String[] expected = {"Фильм 1", "Фильм 2", "Фильм 3"};
        assertArrayEquals(expected, result);
    }

    @Test
    void testFindAllWithNoMovies() {

        MovieManager manager = new MovieManager();

        String[] result = manager.findAll();


        String[] expected = {};
        assertArrayEquals(expected, result);
    }


    @Test
    void testFindLastWithDefaultLimit() {

        MovieManager manager = new MovieManager();
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");
        manager.addMovie("Фильм 6");


        String[] result = manager.findLast();


        String[] expected = {"Фильм 6", "Фильм 5", "Фильм 4", "Фильм 3", "Фильм 2"};
        assertArrayEquals(expected, result);
    }

    @Test
    void testFindLastWithCustomLimit() {

        MovieManager manager = new MovieManager(3);
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");


        String[] result = manager.findLast();


        String[] expected = {"Фильм 4", "Фильм 3", "Фильм 2"};
        assertArrayEquals(expected, result);
    }

    @Test
    void testFindLastWhenFewerMoviesThanLimit() {

        MovieManager manager = new MovieManager(3);
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");


        String[] result = manager.findLast();


        String[] expected = {"Фильм 2", "Фильм 1"};
        assertArrayEquals(expected, result);
    }

}