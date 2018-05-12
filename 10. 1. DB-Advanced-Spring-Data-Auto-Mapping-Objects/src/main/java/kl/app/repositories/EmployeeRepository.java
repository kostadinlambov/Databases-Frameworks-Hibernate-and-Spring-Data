package kl.app.repositories;

import kl.app.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

List<Employee> findByBirthDateBeforeOrderBySalaryDesc(LocalDate before);

}
