package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImp;

public class DeleteATeamById {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			TeamDao dao = new TeamDaoImp();
			dao.getAllTeamIdsAndAbbreviations()
				.forEach(x -> System.out.println(x.getId()+ "  ->  " + x.getAbbreviation()));
			System.out.println("Enter team id to be deleted");
			System.out.println(dao.deleteTeamDetails(sc.nextLong()));
		} // JVM : sf.close() ---> DBCP : cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
