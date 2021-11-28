package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT b FROM Employee b WHERE b.id= ?1")
    Employee employeeByIdStylist(Integer StylistId);

    @Query(value = "SELECT b FROM Employee b WHERE b.role.id= 2 and  b.statusWork = 1")
    List<Employee> bookingByStylist();
}
