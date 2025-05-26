package main;

import java.util.List;

import org.hibernate.Session;

import model.Employee;

public class Pony02 {

 public static void main(String[] args) {
  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
   String sql = "SELECT EmployeeID, Title, FirstName, LastName " +
  "FROM employees ORDER BY Title ASC, LastName DESC";

   List<Employee> employees = session.createNativeQuery(sql, Employee.class).getResultList();

   System.out.println("02");
   System.out.println("-------");
   
   for (Employee employee : employees) {
    System.out.printf("%d. %s : %s %s\n", 
      employee.getEmployeeId(), 
      employee.getTitle(),
      employee.getLastName(), 
      employee.getFirstName());
   }

   System.out.println("OK");
  } catch (Exception e) {

  }

 }

}