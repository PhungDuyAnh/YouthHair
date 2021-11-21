package poly.datn.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	private Integer id;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String address;

	private String fullName;

	private Boolean gender;

	private String image;

	private String phone;

	private int salary;

	@Temporal(TemporalType.DATE)
	private Date startDate;
	

	private Boolean statusWork;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="employee1")
	@JsonIgnore
	private List<Booking> bookings;

	//bi-directional one-to-one association to Booking
//	@OneToOne(mappedBy="employee2")
//	@JsonIgnore
//	private Booking booking;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="RolesId")
	private Role role;



}