package poly.datn.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingIatDTO {
    private Integer idSty;
    private Time totalTime;

}
