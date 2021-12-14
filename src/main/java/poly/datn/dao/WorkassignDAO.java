package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import poly.datn.entity.Workassign;

import java.util.List;

public interface WorkassignDAO extends JpaRepository<Workassign, Integer> {
    
}
