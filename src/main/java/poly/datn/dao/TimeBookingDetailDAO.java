package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.Account;
import poly.datn.entity.TimeBookingDetail;

public interface TimeBookingDetailDAO extends JpaRepository<TimeBookingDetail, Integer> {

//    @Query(value = "SELECT b FROM TimeBookingDetail b WHERE b.username = ?1")
//    Account findByName(String username);

}
