package poly.datn.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * The persistent class for the contacts database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="timebookingdetail")
@NamedQuery(name="TimeBookingDetail.findAll", query="SELECT tbd FROM TimeBookingDetail tbd")
public class TimeBookingDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer bookingId;
	
	private Integer stylistId;
	
	private Integer timeBookingId;
	
	
	//bi-directional many-to-one association to Customer
//	@ManyToOne
//	@JoinColumn(name="CustomerId")
//	@JsonIgnore
//	private Customer customer;


}