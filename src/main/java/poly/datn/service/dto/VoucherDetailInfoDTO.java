package poly.datn.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.datn.entity.Booking;
import poly.datn.entity.Customer;
import poly.datn.entity.Voucher;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherDetailInfoDTO {

    private int voting;

    private int CusId;

    private String voucherId;

    private float totalPrice;

}
