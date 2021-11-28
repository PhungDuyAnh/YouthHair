package poly.datn.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poly.datn.entity.Services;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailDTO {

	private List<Services> listSer ;
	
}
