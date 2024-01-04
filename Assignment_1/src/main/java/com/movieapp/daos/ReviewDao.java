package com.movieapp.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.movieapp.pojos.Review;

public class ReviewDao extends Dao implements IReviewDao{
	
	private PreparedStatement writeReviewSQL;
	private PreparedStatement displayAllReviewSQL;
	private PreparedStatement displayMyReviewSQL;
	private PreparedStatement deleteMyReviewSQL;
	private PreparedStatement editMyReviewSQL;
	private PreparedStatement sharedReviewSQL;
	private PreparedStatement findByReviewId;
	private PreparedStatement shareReviewSQL;

	public ReviewDao() throws Exception {
		super();
		writeReviewSQL = con.prepareStatement("INSERT INTO reviews VALUES(default,?,?,?,?,?)");
		displayAllReviewSQL = con.prepareStatement("SELECT * from reviews");
		displayMyReviewSQL = con.prepareStatement("SELECT * from reviews where user_id=?");
		deleteMyReviewSQL = con.prepareStatement("DELETE FROM reviews WHERE id = ?");
		editMyReviewSQL = con.prepareStatement("UPDATE reviews SET review = ?, rating = ?, modified = ? WHERE id = ?");
		sharedReviewSQL = con.prepareStatement("SELECT r.* FROM reviews r JOIN shares s ON r.id = s.review_id and s.user_id=?");
		findByReviewId = con.prepareStatement("SELECT * FROM reviews WHERE id = ?");
		shareReviewSQL = con.prepareStatement("INSERT into shares values(?, ?)");
	}

	@Override
	public int save(Review r) throws Exception {
		writeReviewSQL.setInt(1, r.getMovie_id());
		writeReviewSQL.setString(2, r.getReview());
		writeReviewSQL.setInt(3, r.getRating());
		writeReviewSQL.setInt(4, r.getUser_id());
		writeReviewSQL.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));

		return writeReviewSQL.executeUpdate();
	}

	@Override
	public int update(Review r) throws Exception {
		editMyReviewSQL.setString(1, r.getReview());
		editMyReviewSQL.setInt(2, r.getRating());
		editMyReviewSQL.setInt(3, r.getUser_id());
		editMyReviewSQL.setTimestamp(4, new Timestamp(new Date().getTime()));
		editMyReviewSQL.setInt(5, r.getId());
		
		return editMyReviewSQL.executeUpdate();
	}

	@Override
	public List<Review> findAll() throws Exception {
		List<Review> list = new ArrayList<Review>();
		try(ResultSet rs = displayAllReviewSQL.executeQuery()){
			while(rs.next())
			{
				Review obj = new Review();
				obj.setId(rs.getInt("id"));
				obj.setMovie_id(rs.getInt("movie_id"));
				obj.setReview(rs.getString("review"));
				obj.setRating(rs.getInt("rating"));
				obj.setUser_id(rs.getInt("user_id"));
				Timestamp temp = rs.getTimestamp("modified");
				obj.setModified(new Date(temp.getTime()));
				list.add(obj);
			}
		}
		return list;
	}

	@Override
	public List<Review> findByUserId(int userId) throws Exception {
		List<Review> list = new ArrayList<Review>();
		displayMyReviewSQL.setInt(1, userId);
		
		try(ResultSet rs = displayMyReviewSQL.executeQuery()){
			while(rs.next())
			{
				Review obj = new Review();
				obj.setId(rs.getInt("id"));
				obj.setMovie_id(rs.getInt("movie_id"));
				obj.setReview(rs.getString("review"));
				obj.setRating(rs.getInt("rating"));
				obj.setUser_id(rs.getInt("user_id"));
				Timestamp temp = rs.getTimestamp("modified");
				obj.setModified(new Date(temp.getTime()));
				
				list.add(obj);
			}
		}
		return list;
	}

	@Override
	public List<Review> getSharedWithUser(int userId) throws Exception {
		sharedReviewSQL.setInt(1, userId);
		
		List<Review> list = new ArrayList<Review>();
		
		try(ResultSet rs = sharedReviewSQL.executeQuery()){
			while(rs.next()) {
				Review obj = new Review();
				obj.setId(rs.getInt("id"));
				obj.setMovie_id(rs.getInt("movie_id"));
				obj.setReview(rs.getString("review"));
				obj.setRating(rs.getInt("rating"));
				obj.setUser_id(rs.getInt("user_id"));
				Timestamp temp = rs.getTimestamp("modified");
				obj.setModified(new Date(temp.getTime()));
				
				list.add(obj);
			}
		}
		return list;
	}

	@Override
	public Optional<Review> findById(int id) throws Exception {
		try(ResultSet rs = findByReviewId.executeQuery()){
			while(rs.next())
			{
				Review obj = new Review();
				obj.setId(rs.getInt("id"));
				obj.setMovie_id(rs.getInt("movie_id"));
				obj.setReview(rs.getString("review"));
				obj.setRating(rs.getInt("rating"));
				obj.setUser_id(rs.getInt("user_id"));
				Timestamp temp = rs.getTimestamp("modified");
				obj.setModified(new Date(temp.getTime()));
				
				return Optional.of(obj);
			}
		}
		return Optional.empty();
	}

	@Override
	public int deleteById(int reviewId) throws Exception {
		deleteMyReviewSQL.setInt(1, reviewId);
		return deleteMyReviewSQL.executeUpdate();
	}

	@Override
	public int shareReview(int reviewId, int userId) throws Exception {
		shareReviewSQL.setInt(1, reviewId);
		shareReviewSQL.setInt(2, userId);
		
		return shareReviewSQL.executeUpdate();
	}

}
