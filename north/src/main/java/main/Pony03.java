package main;

import java.util.List;

import org.hibernate.Session;

import model.Employee;

public class Pony03 {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "SELECT FirstName, LastName " +
		"FROM employees ORDER BY Title ASC, LastName DESC";

			List<Object[]> employees = session.createNativeQuery(sql, Object[].class).getResultList();

			System.out.println("03");
			System.out.println("-------");
			
			for (Object[] employee : employees) {
				System.out.printf("%s %s\n",
						employee[1],
						employee[0]);
			}

			System.out.println("OK");
		} catch (Exception e) {

		}

	}

}