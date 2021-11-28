package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.datn.entity.Booking;
import poly.datn.entity.Employee;

import java.util.List;

public interface BookingDAO extends JpaRepository<Booking, Integer> {


    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = ?1")
    List<Booking> bookingByStatus(String status);

    @Query(value = "SELECT e.fullName FROM Employee e")
    String[] finbyEmployee();

    @Query(value = "SELECT e FROM Employee e where e.role.id=2 and e.statusWork=true ")
    List<Employee>  findByRoleAndSatus();

    @Query(value = "SELECT b from Booking b where b.statusbooking.id='WFC' AND b.employee1.role.id=2 ")
    List<Booking> findByStatusWFCAndStylist();

}
