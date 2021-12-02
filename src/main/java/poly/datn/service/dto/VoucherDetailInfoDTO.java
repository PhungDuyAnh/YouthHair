package poly.datn.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherDetailInfoDTO {
    private int CusId;
    private String voucherId;
    private int voting;
    private float totalPrice;




}
