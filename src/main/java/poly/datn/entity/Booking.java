package poly.datn.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the booking database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	private LocalDateTime time;
	
	private String note;

//	private int stylistId;

	private float totalPrice;

	private LocalTime totalTime;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CustormerId")
	private Customer customer;

<<<<<<< HEAD
=======
	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="StylistId")
	private Employee employee1;

>>>>>>> main
	//bi-directional many-to-one association to Statusbooking
	@ManyToOne
	@JoinColumn(name="StatusId")
	private Statusbooking statusbooking;

	//bi-directional many-to-one association to Voting
	@ManyToOne
	@JoinColumn(name="VotingId")
	private Voting voting;
	
	//bi-directional many-to-one association to VoucherDetails
	@ManyToOne
	@JoinColumn(name="VoucherDetailsId")
	private Voucherdetail voucherdetails;

	//bi-directional many-to-one association to Bookingdetail
	@OneToMany(mappedBy="booking")
	@JsonIgnore
	private List<BookingDetail> bookingdetails;


}