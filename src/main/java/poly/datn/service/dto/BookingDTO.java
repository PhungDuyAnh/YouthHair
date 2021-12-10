package poly.datn.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.datn.entity.Employee;
import poly.datn.entity.Services;
import java.sql.Time;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    //booking

    private Integer id;

    private Date createDate;

    private String note;

    //Employee
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Employee> employee1;

    private float totalPrice;

    private Time totalTime;

    private Time time;

    //Service
    private List<Services> listSer;


}
