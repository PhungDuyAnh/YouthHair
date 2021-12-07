package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.datn.entity.Booking;
import poly.datn.entity.Employee;

import javax.persistence.Tuple;
import java.util.List;

public interface BookingDAO extends JpaRepository<Booking, Integer> {


    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = ?1")
    List<Booking> bookingByStatus(String status);

    @Query(value = "SELECT e.fullName FROM Employee e")
    String[] finbyEmployee();

    @Query(value = "SELECT e FROM Employee e where e.role.id=2 and e.statusWork=true ")
    List<Employee>  findByRoleAndSatus();

    @Query(value = "SELECT b from Booking b where b.statusbooking.id='WFC' AND b.employee1.role.id=2 and b.id=?1")
    List<Booking> findByStatusWFCAndStylist(int id);

    @Query(value = "SELECT b FROM Booking b  WHERE b.customer.id = :customer and b.statusbooking.id = 'UCF' ")
    Booking bookingByCustomer(@Param("customer") Integer customer );

    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = 'IAT' and b.employee1.id = ?1")
    Booking bookingCusByStylist(Integer id);

    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = 'WFP' and b.customer.id = ?1")
    Booking bookingCusByCusWFP(Integer id);

    @Query(value = "SELECT b.employee1.id , b.totalTime FROM Booking b WHERE b.statusbooking.id = 'IAT' ")
    List<Tuple> bookingIAT();

    @Query(value = "SELECT b FROM Booking b WHERE b.customer.phone = ?1  and b.statusbooking.id='UCF' ")
    Booking checkBookingIAT(String phone);

    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = 'IAT' AND b.employee1.id = ?1 ")
	Booking findBookingIATbyStylist(Integer id);
    
    @Query(value = "SELECT b FROM Booking b WHERE b.statusbooking.id = 'WFC' AND b.employee1.id = ?1 ")
    List<Booking> findBookingWFCbyStylist(Integer id);
}
