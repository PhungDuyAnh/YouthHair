package poly.datn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import poly.datn.entity.Voucher;
import poly.datn.entity.Voucherdetail;
import poly.datn.service.dto.VoucherDetailInfoDTO;

import java.util.List;

public interface VoucherDetailDAO extends JpaRepository<Voucherdetail, Integer> {
    @Query(value = "SELECT vd.id, vd.status, vd.customer.id, vd.voucher.id,v.condition,v.note,v.price  FROM Voucherdetail vd join Voucher v on vd.voucher.id = v.id  where vd.customer.id = ?1 and vd.status = true ")
    List<VoucherDetailInfoDTO> selectVoucherByCus(Integer id);
}
