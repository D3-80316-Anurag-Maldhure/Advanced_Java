package com.movieapp.daos;

import java.util.List;
import java.util.Optional;

import com.movieapp.pojos.User;

public interface IUserDao extends AutoCloseable {
    public int save(User u) throws Exception;
    
    public int update(User u) throws Exception;
    
    public int updatePassword(int userId, String newPassword) throws Exception;
    
    public Optional<User> findByEmail(String email) throws Exception;
    
    public List<User> findAll() throws Exception;
}