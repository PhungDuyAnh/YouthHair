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
@Table(name="booking_detail_views")
@NamedQuery(name="BookingDetailView.findAll", query="SELECT b FROM BookingDetailView b")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookingDetailView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BookingID", nullable = false)
	private int bookingID;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	private String customerEmail;

	private String customerName;

	private String customerPhone;

	private String note;

	private String serviceName;

	private String statusName;

	private String stylistName;

	private Time time;

	private float totalPrice;

	private String totalTime;

}