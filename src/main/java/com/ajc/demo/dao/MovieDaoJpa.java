package com.ajc.demo.dao;

import com.ajc.demo.dao.base.MovieDao;
import com.ajc.demo.model.Movie;
import com.ajc.demo.utils.JpaDaoManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDaoJpa implements MovieDao {
    @Override
    public Long save(Movie obj) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        Movie movie=new Movie();
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            System.out.println("ici");
            movie=em.merge(obj);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());

            if (transaction != null) transaction.rollback();
        } finally {
            if (em != null) em.close();
        }
        return movie.getId();
    }

    @Override
    public List<Movie> findAll() {
        EntityManager em = null;
        List<Movie> userArrayList = new ArrayList<>();
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Movie ");
            userArrayList = query.getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return userArrayList;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        EntityManager em = null;
        Movie user = null;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query = em.createQuery("from Movie where id = :first");
            query.setParameter("first", aLong);
            user = (Movie) query.getSingleResult();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) em.close();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public boolean update(Movie obj) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        boolean isUpdate=false;
        try {
            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(obj);
            transaction.commit();
            isUpdate=true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        } finally {
            if (em != null) em.close();
        }
        return isUpdate;
    }

    @Override
    public void delete(Long aLong) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {

            em = JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            Optional<Movie> user = em.merge(this.findById(aLong));
            em.remove(user);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            if (transaction != null) transaction.rollback();
        } finally {
            if (em != null) em.close();
        }
    }


}
