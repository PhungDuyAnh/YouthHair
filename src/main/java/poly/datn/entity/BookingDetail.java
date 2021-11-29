package poly.datn.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;


/**
 * The persistent class for the bookingdetails database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bookingdetails")
@NamedQuery(name="BookingDetail.findAll", query="SELECT b FROM BookingDetail b")
public class BookingDetail implements Serializable {
	private static final long serialVersionUID = 1L;
//	@EmbeddedId
//	private BookingDetailPK id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private float price;

	private Time time;

	//bi-directional many-to-one association to Booking
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="BookingId")
	private Booking booking;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="ServiceId")
	private Services service;
}