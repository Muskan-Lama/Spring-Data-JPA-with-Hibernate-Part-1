package com.TTN.db.repo;

import com.TTN.db.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;



//(7) Implement Pagination and Sorting on the bases of Employee Age
//extending PagingAnd SortingRepository
public interface PaginationAndSorting extends PagingAndSortingRepository<Employee,Integer>
{


}
