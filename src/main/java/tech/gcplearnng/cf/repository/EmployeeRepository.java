package tech.gcplearnng.cf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tech.gcplearnng.cf.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>  {

}
