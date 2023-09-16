package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Director.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            С помощью Hibernate получите любого режиссера, а затем получите список его фильмов.
            System.out.println("first task:");
            Director director = session.get(Director.class, 1);
            List<Movie> movieList = director.getListOfMovies();

            for (Movie movie : movieList) {
                System.out.println(movie);
            }
//            Получите любой фильм, а затем получите его режиссера.
            System.out.println("second task:");
            Movie movie = session.get(Movie.class, 9);
            Director director1 = movie.getMovieDirector();
            System.out.println(director1);
//            Добавьте еще один фильм для любого режиссера.
            System.out.println("third task:");
            Director director2 = session.get(Director.class, 5);
            Movie movie1 = new Movie("movie by director5", 2023);
            director2.getListOfMovies().add(movie1);

            movie1.setMovieDirector(director2);

            session.persist(movie1);
//            Создайте нового режиссера и новый фильм и свяжите эти сущности.
            System.out.println("forth task:");
            Director director3 = new Director("Greta Gerwig", 40);
            Movie movie2 = new Movie("Barbie", 2023);
//
            director3.setListOfMovies(new ArrayList<>(Collections.singletonList(movie2)));
            movie2.setMovieDirector(director3);
            session.persist(director3);
            session.persist(movie2);
//            Смените режиссера у существующего фильма.
            Movie movie3 = session.get(Movie.class, 13);
            movie3.getMovieDirector().getListOfMovies().remove(movie3);

            Director director4 = session.get(Director.class, 6);
            movie3.setMovieDirector(director4);
            director4.getListOfMovies().add(movie3);
//            Удалите фильм у любого режиссера.
            Movie movie4 = session.get(Movie.class, 4);
            Director director5 = movie4.getMovieDirector();

            session.remove(movie4);
            director5.getListOfMovies().remove(movie4);
            session.getTransaction().commit();
        }
    }
}
