package poly.datn.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.datn.entity.Customer;
import poly.datn.entity.Voucher;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoucherDetailInfoDTO {

    private int id;

    private Boolean status;

    private int customerId;

    private String voucherId;

    private float condition;

    private String note;

    private float price;
}
