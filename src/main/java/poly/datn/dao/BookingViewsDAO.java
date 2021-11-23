package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.BookingDetailView;
import poly.datn.entity.BookingView;

import java.util.List;

public interface BookingViewsDAO extends JpaRepository<BookingView,Integer> {


    @Query("SELECT b FROM BookingView  b where b.statusName=?1")
    List<BookingView> findByStatusName(String statusName);

}
