package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.datn.entity.Account;
import poly.datn.entity.TimeBookingDetail;

import javax.validation.constraints.Max;
import java.sql.Date;
import java.util.List;

public interface TimeBookingDetailDAO extends JpaRepository<TimeBookingDetail, Integer> {

//    @Query(value = "SELECT b FROM TimeBookingDetail b WHERE b.username = ?1")
//    Account findByName(String username);

      @Query(value = "SELECT b from TimeBookingDetail b where (b.stylistId=:styId) and (b.date=:date) and (b.bookingId <>:bookingId)")
      List<TimeBookingDetail> getCheckTimebooking(@Param("styId") Integer id, @Param("date") Date date , @Param("bookingId") Integer bookingId);



}
