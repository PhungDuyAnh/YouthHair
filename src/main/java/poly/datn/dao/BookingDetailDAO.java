package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.datn.entity.BookingDetail;
import poly.datn.entity.BookingDetailPK;

import javax.persistence.Tuple;
import java.util.List;

public interface BookingDetailDAO extends JpaRepository<BookingDetail, BookingDetailPK>{
    @Query(value = "SELECT s.service.serviceName,s.service.image FROM BookingDetail s WHERE s.booking.id =?1")
    List<Tuple> selectServiceByIdBooking(Integer id);

    @Query(value = "SELECT b.service.id FROM BookingDetail b where b.booking.id=?1")
    List<Tuple> getBookingByIDBooking(Integer id);

}
