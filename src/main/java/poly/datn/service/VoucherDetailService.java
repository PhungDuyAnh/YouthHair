package poly.datn.service;

import java.util.List;

import poly.datn.service.dto.VoucherDetailInfoDTO;

public interface VoucherDetailService {

    List<VoucherDetailInfoDTO> VoucherByCus(Integer id);
}
