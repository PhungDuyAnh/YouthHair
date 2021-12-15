package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import poly.datn.entity.Employee;
import poly.datn.entity.Workassign;

import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;

public interface WorkassignDAO extends JpaRepository<Workassign, Integer> {

	@Query("SELECT w FROM Workassign w WHERE w.employee.id = :employeeId")
	List<Workassign> checkWorkassignNull(@Param("employeeId") Integer id);
	
	@Query("SELECT distinct (w.date) FROM Workassign w")
	List<Tuple> disctinctDate();

	@Query("SELECT w FROM Workassign w WHERE w.date = ?1  AND w.employee.role.id = 2 AND w.employee.statusWork = true")
	List<Workassign> findWorkassignStylist(Date date);
    
}
