package com.movieapp.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.movieapp.pojos.User;
import com.movieapp.util.*;

public class UserDao extends Dao implements IUserDao{
	
	private PreparedStatement saveUserStatement;
	private PreparedStatement editUserSQL;
	private PreparedStatement editPassSQL;
	private PreparedStatement displayAllUsers;

	public UserDao() throws Exception {
		super();
		//Pre - compiled statements
		saveUserStatement = con.prepareStatement("INSERT INTO users VALUES(default,?,?,?,?,?,?)");
		editUserSQL = con.prepareStatement("UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ?, mobile = ?, birth = ?  WHERE id = ?");
		editPassSQL = con.prepareStatement("UPDATE users SET password = ? WHERE id = ?");
		displayAllUsers = con.prepareStatement("SELECT * from users");
	}
	
	@Override
	public int save(User u) throws Exception {
//		String saveUserStatement = "INSERT INTO users VALUES(default, ?, ?, ?, ?, ?, ?)";
//		try(PreparedStatement stmt1 = con.prepareStatement(saveUserStatement)) {
			saveUserStatement.setString(1, u.getFirst_name());
			saveUserStatement.setString(2, u.getLast_name());
			saveUserStatement.setString(3, u.getEmail());
			saveUserStatement.setString(4, u.getPassword());
			saveUserStatement.setString(5, u.getMobile());
			saveUserStatement.setDate(6, DateUtil.utilToSqlDate(u.getBirth()));
			int count = saveUserStatement.executeUpdate();
			return count;
//		} //stmt.close();
	}

	@Override
	public int update(User u) throws Exception {
		editUserSQL.setString(1, u.getFirst_name());
		editUserSQL.setString(2, u.getLast_name());
		editUserSQL.setString(3, u.getEmail());
		editUserSQL.setString(4, u.getPassword());
		editUserSQL.setString(5, u.getMobile());
		java.sql.Date sDate = DateUtil.utilToSqlDate(u.getBirth());
		editUserSQL.setDate(6, sDate);
		
		editUserSQL.setInt(7, u.getId());
		
		return editUserSQL.executeUpdate();
	}

	@Override
	public int updatePassword(int userId, String newPassword) throws Exception {
		editPassSQL.setString(1, newPassword);
		editPassSQL.setInt(2, userId);
		
		return editPassSQL.executeUpdate();
	}

	//Just another way of implementation - Not pre compiled statements
	@Override
	public Optional<User> findByEmail(String email) throws Exception {
		String findByEmailStatement = "SELECT * FROM users where email = ?";
		try(PreparedStatement stmt2 = con.prepareStatement(findByEmailStatement)) {
			stmt2.setString(1, email);
			try(ResultSet resultset = stmt2.executeQuery()){
				while(resultset.next()) {
					int ide 			= resultset.getInt("id");
					String first_name   = resultset.getString("fname");
					String last_name	= resultset.getString("lname");
					String emailString	= resultset.getString("email");
					String password		= resultset.getString("password");
					String mobile_no 	= resultset.getString("mobile");
					Date birth_date		= resultset.getDate("birth");
					
					User foundUser = new User(ide, first_name, last_name, emailString, password, birth_date, mobile_no);
					return Optional.of(foundUser);
				}
			}
		} //stmt.close();
		return Optional.empty();
	}

	@Override
	public List<User> findAll() throws Exception {
		List<User> list = new ArrayList<User>();
		try(ResultSet rs = displayAllUsers.executeQuery()){
			while(rs.next())
			{
				User obj = new User();
				obj.setId(rs.getInt("id"));
				obj.setFirst_name(rs.getString("first_name"));
				obj.setLast_name(rs.getString("last_name"));
				obj.setEmail(rs.getString("email"));
				obj.setPassword(rs.getString("password"));
				obj.setMobile(rs.getString("mobile"));
				obj.setBirth(rs.getDate("birth"));
				
				list.add(obj);
			}
		}
		return list;
	}
	
	
	
}
