package main;

import java.util.List;

import org.hibernate.Session;

import model.Employee;

public class Pony01 {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "SELECT * FROM employees ORDER BY Title ASC, LastName DESC";

			List<Employee> employees = session.createNativeQuery(sql, Employee.class).getResultList();
			System.out.println(">>> fetch count = " + employees.size());
			for (Employee employee : employees) {
				System.out.printf("%d. %s : %s %s\n", employee.getEmployeeId(), employee.getTitle(),
						employee.getLastName(), employee.getFirstName());
			}

			System.out.println("OK");
		} catch (Exception e) {

		}

	}

}