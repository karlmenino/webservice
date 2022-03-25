package com.ajc.demo.rest;

import com.ajc.demo.dao.DaoFactory;
import com.ajc.demo.model.CreateMovie;
import com.ajc.demo.model.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class MovieController {
    private static final List<Movie> movies = new ArrayList<>();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(movies).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMovie(CreateMovie createMovie){

        Movie movie = new Movie(createMovie.getTitle(), createMovie.getDuration(), createMovie.getLocalDate());
        DaoFactory.getMovieDao().save(movie);
        return Response.status(201).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        DaoFactory.getMovieDao().delete(id);
        return Response.ok(movies).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Movie Movie) {
       boolean isUpdate = DaoFactory.getMovieDao().update(Movie);
        if (isUpdate) return Response.status(204).build();
        return Response.status(404)
                .entity("Le film ne peut pas être mise à jour car la ressource n'existe pas")
                .build();
    }
}