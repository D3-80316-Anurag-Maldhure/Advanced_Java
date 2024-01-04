package com.movieapp.daos;

import java.sql.Connection;

import com.movieapp.util.DBUtil;


public class Dao implements AutoCloseable{
	protected Connection con;
	public Dao() throws Exception {
		con = DBUtil.getConnection();
	}
	public void close() throws Exception {
		if(con != null)
			con.close();
	}
}