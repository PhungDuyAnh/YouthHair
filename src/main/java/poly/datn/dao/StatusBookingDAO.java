package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.Statusbooking;

public interface StatusBookingDAO extends JpaRepository<Statusbooking, String> {
    @Query(value = "SELECT b FROM Statusbooking b  WHERE b.id = 'UCF' ")
    Statusbooking StatusbookingbyId();

    @Query(value = "SELECT b FROM Statusbooking b  WHERE b.id = 'CPM' ")
    Statusbooking StatusbookingbyIdCPM();

    @Query(value = "SELECT b FROM Statusbooking b  WHERE b.id = 'WFC' ")
    Statusbooking StatusbookingbyIdWFC();
}
