package main;

import java.util.List;

import org.hibernate.Session;

import model.Employee;

public class Pony05 {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "SELECT e.employeeId, e.title, e.firstName, e.lastName " +
					  "FROM Employee e ORDER BY e.title ASC, e.lastName DESC";

			List<Employee> employees = session.createQuery(hql, Employee.class).getResultList();

			System.out.println("05");
			System.out.println("-------");

			for (Employee employee : employees) {
				System.out.printf("%d. %s : %s %s\n", employee.getEmployeeId(), employee.getTitle(),
						employee.getLastName(), employee.getFirstName());
			}

			System.out.println("OK");
		} catch (Exception e) {

		}

	}

}