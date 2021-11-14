package poly.datn.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.datn.entity.Services;

public interface ServiceDAO extends JpaRepository<Services, Integer> {
    @Query("update Services set status = 0 where id = :id")
    Services updateStatus(@Param("id") Integer id);
}
