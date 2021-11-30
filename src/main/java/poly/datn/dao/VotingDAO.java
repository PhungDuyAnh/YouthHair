package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.Voting;
import poly.datn.entity.Voucherdetail;

public interface VotingDAO extends JpaRepository<Voting, Integer>{

    @Query(value = "SELECT v FROM Voting v where v.id=?1")
            Voting selectVotingById(Integer id);
}
