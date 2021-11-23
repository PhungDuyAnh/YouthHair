package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.BookingDetailView;

import java.util.List;

public interface BookingDetailsViewsDAO extends JpaRepository<BookingDetailView,Integer> {

    @Query("SELECT b FROM BookingDetailView  b where b.statusName=?1")
    List<BookingDetailView> findByStatusName(String statusName);

}
