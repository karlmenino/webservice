package com.ajc.demo.dao;

import com.ajc.demo.dao.base.MovieDao;


public final class DaoFactory {

    private DaoFactory() {
    }

    public static MovieDao getMovieDao(){
        return new MemoryMovieDao();
    }
    public static MovieDao getJpaMovieDao(){
        return new MovieDaoJpa();
    }
}
