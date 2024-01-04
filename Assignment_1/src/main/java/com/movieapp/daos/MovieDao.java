package com.movieapp.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.movieapp.pojos.Movie;
import com.movieapp.util.*;

public class MovieDao extends Dao implements IMovieDao{
	
	private PreparedStatement getAllMoviesSQL;
	private PreparedStatement getMovieByIdSQL;
	
	public MovieDao() throws Exception {
		getAllMoviesSQL = con.prepareStatement("SELECT * FROM movies");
		getMovieByIdSQL = con.prepareStatement("SELECT * from movies WHERE id = ?");
	}

	@Override
	public List<Movie> findAll() throws Exception {
		List<Movie> list = new ArrayList<Movie>();
		try(ResultSet rs = getAllMoviesSQL.executeQuery()){
			while(rs.next())
			{
				Movie obj = new Movie();
				obj.setId(rs.getInt("id"));
				obj.setTitle(rs.getString("title"));
				obj.setRel_date(DateUtil.sqlToUtilDate(rs.getDate("rel_date")));
				
				list.add(obj);
			}
		}
		return list;
	}

	@Override
	public Optional<Movie> findById(int id) throws Exception {
		getMovieByIdSQL.setInt(1, id);
		try(ResultSet rs = getMovieByIdSQL.executeQuery()) {
			while(rs.next()) {
				Movie obj = new Movie();
				obj.setId(rs.getInt("id"));
				obj.setTitle(rs.getString("title"));
				obj.setRel_date(DateUtil.sqlToUtilDate(rs.getDate("rel_date")));
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}
}
