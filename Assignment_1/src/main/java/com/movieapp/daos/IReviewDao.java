package com.movieapp.daos;

import java.util.List;
import java.util.Optional;

import com.movieapp.pojos.Review;

public interface IReviewDao extends AutoCloseable {
    public int save(Review r) throws Exception;
    
    public int update(Review r) throws Exception;
    
    public List<Review> findAll() throws Exception;
    
    public List<Review> findByUserId(int userId) throws Exception;
    
    public List<Review> getSharedWithUser(int userId) throws Exception;
    
    public Optional<Review> findById(int id) throws Exception;
    
    public int deleteById(int reviewId) throws Exception;
    
    public int shareReview(int reviewId, int userId) throws Exception;
}