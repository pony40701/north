package main;
/*
 SELECT ProductName,UnitsInStock,ReorderLevel,UnitsOnOrder
FROM `products`
WHERE UnitsInStock <= ReorderLevel
 */

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Employee;

public class Pony08 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = builder.createQuery(Employee.class);
			Root<Employee> root = cq.from(Employee.class);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
