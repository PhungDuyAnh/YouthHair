package poly.datn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the booking_views database table.
 * 
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="booking_views")
@NamedQuery(name="BookingView.findAll", query="SELECT b FROM BookingView b")
public class BookingView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int bookingID;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	private String customerEmail;

	private String customerName;

	private String customerPhone;

	private String note;

	private String statusName;

	private String stylistName;

	private Time time;

	private float totalPrice;

	private String totalTime;


}