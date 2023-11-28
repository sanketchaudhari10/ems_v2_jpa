package in.co.vwits.ems.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_employee")
public class Employee implements Comparable<Employee> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // This will automatically increment value of rollNo using database.
	private int id;
	@Column(name="emp_name",nullable = false)
	private String name;
	@Column(name="emp_salary")
	private int salary;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return o.salary-this.salary;
	}

}
