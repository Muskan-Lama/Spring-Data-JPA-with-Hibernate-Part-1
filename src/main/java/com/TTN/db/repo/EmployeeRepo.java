package com.TTN.db.repo;

import com.TTN.db.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;


//(2) Set up EmployeeRepository with Spring Data JPA
//creating repository
//Integer is the type pf primary key
/*public interface EmployeeRepo extends CrudRepository<Employee,Integer>*/
//implementing CrudRepository
public interface EmployeeRepo extends CrudRepository<Employee,Integer>
    //enabling paging and sorting by extending the class

{
    //paging and sorting custom on the basis of age
//(8) Create and use finder to find Employee by Name
List<Employee> findByName(String name);
//age between 28 to 32
    List<Employee> findByAgeBetween(int age1, int age2);

    //(9) Create and use finder to find Employees starting with A character
    List<Employee> findByNameLike(String name);

}
