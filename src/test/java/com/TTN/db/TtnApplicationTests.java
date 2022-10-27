package com.TTN.db;

import com.TTN.db.repo.EmployeeRepo;
import com.TTN.db.repo.PaginationAndSorting;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class TtnApplicationTests {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	PaginationAndSorting paginationAndSorting;

	@Test
	public void contextLoads()
	{

	}

//(3) Perform Create Operation on Entity using Spring Data JPA
	@Test
	public void testCreate(){

		Employee employee=new Employee();
		employee.setName("Poornima");
		employee.setId(12);
		employee.setAge(23);
		employee.setLocation("Noida");

		//saving to db
		employeeRepo.save(employee);

	}
	//(4) Perform Update Operation on Entity using Spring Data JPA

	@Test
	public void testUpdate()
	{
		//getting records whose id is 12 and storing it to employee
	Employee employee=employeeRepo.findById(4).get();
	//setting name of an  employee whose id =12
	employee.setAge(21);
	//saving
	employeeRepo.save(employee);


	}

	//(5) Perform Delete Operation on Entity using Spring Data JPA
	@Test
	public void testDelete()
	{
		//deleting the data which has 12 as id
    employeeRepo.deleteById(12);
	}
	 //(5) Perform Read Operation on Entity using Spring Data JPA

	@Test
	//reading name whose id is 2
	public void testRead() {
		Employee employee=  employeeRepo.findById(2).get();
		System.out.println(employee.getAge());

	}
	//(6) Get the total count of the number of Employees
	//get total n.o of rows in the table
	@Test
	public void testCount()
	{
		System.out.println("N.o of rows : "+employeeRepo.count());
	}

	//employee whose name sofi and getting its location
	@Test
	public void findByName(){
		List<Employee> employees = employeeRepo.findByName("Sofi");
		employees.forEach(e -> System.out.println(e.getLocation()));
	}

//finding employee whose age is between 28 and 32
	@Test
	public void findByAgeBetween(){
		List<Employee> employees = employeeRepo.findByAgeBetween(28,32);
		employees.forEach(e -> System.out.println(e.getLocation()));
	}

	//(9) Create and use finder to find Employees starting with A character
	@Test
	public void findByNameLike(){
		List<Employee> employees = employeeRepo.findByNameLike("%A%");
		employees.forEach(e -> System.out.println(e.getName()));
	}

	//(7) Implement Pagination and Sorting on the bases of Employee Age

	@Test
	public void testFindAllPagingAndSorting(){

		//sorting by deafult in ascending order by age
		 Pageable pageable =
				PageRequest.of(0,2, Sort.by("age"));
		 //from repository getting all the employee age
		paginationAndSorting.findAll(pageable).forEach(p-> System.out.println(p.getAge()));
	}



}
