package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.datn.entity.Voting;

public interface VotingDAO extends JpaRepository<Voting, Integer>{

}
