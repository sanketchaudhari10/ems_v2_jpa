package in.co.vwits.ems.dao.impl;

import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmployeeJpaDaoImpl implements EmployeeDao {

	private EntityManagerFactory factory;

	public EmployeeJpaDaoImpl(){
		factory=Persistence.createEntityManagerFactory("emsapp");
	}

	@Override
	public int save(Employee e) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);; //This inserts record in the database.
		tx.commit();
		em.close();
		return 1;
		
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		 // CALL A METHOD WHICH RETURNS ALL THE RECORD FROM DATABASE
		String jpql = "FROM Employee";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		tx.commit();
		em.close();
		return employeeList;
		
	}

	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Employee.class, id)); //This fires delete query
		tx.commit();
		em.close();

	}

	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee e = em.find(Employee.class, id); //This fires Select query
		tx.commit();
		em.close();
		return Optional.of(e);
		
	}

	@Override
	public void updateName(Employee e) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(e); //fires update query
		tx.commit();
		em.close();
	}
	
	@Override
	public void updateSalary(Employee e) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(e); //fires update query
		tx.commit();
		em.close();

	}

	@Override
	public void updateSalary() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void updateName(int id, String updateName) {
		// TODO Auto-generated method stub
		
	}

}
