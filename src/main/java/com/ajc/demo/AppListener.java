package com.ajc.demo;

import com.ajc.demo.dao.DaoFactory;
import com.ajc.demo.dao.base.MovieDao;
import com.ajc.demo.model.Movie;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        MovieDao dao = DaoFactory.getMovieDao();
        dao.save(new Movie("La ligne verte", 188, LocalDate.ofYearDay(1999, 1)));
        dao.save(new Movie("Le parrain", 175, LocalDate.ofYearDay(1972, 1)));
        dao.save(new Movie("H2G2 ", 109, LocalDate.ofYearDay(2005, 1)));
        dao.save(new Movie("Que justice soit faite", 104, LocalDate.ofYearDay(2009, 1)));
        dao.save(new Movie("Les affranchis", 146, LocalDate.ofYearDay(1990, 1)));
        dao.save(new Movie("Metropolis", 153, LocalDate.ofYearDay(1927, 1)));
        dao.save(new Movie("Blade Runner 2049", 163, LocalDate.ofYearDay(2017, 1)));
        dao.save(new Movie("Princesse Mononoké", 133, LocalDate.ofYearDay(1997, 1)));
        dao.save(new Movie("Transformers", 224, LocalDate.ofYearDay(2007, 1)));
    }
}
