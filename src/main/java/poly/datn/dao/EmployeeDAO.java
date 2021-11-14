package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.datn.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
