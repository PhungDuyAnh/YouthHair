package poly.datn.rest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poly.datn.entity.Services;
import poly.datn.service.IServiceService;
import poly.datn.service.dto.ServiceDTO;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;

@RestController
@RequestMapping("/rest")
public class ServicesRestController {


	@Autowired
	IServiceService iServiceService;
	@PostMapping("/services")
	public Services create(@RequestBody ServiceDTO services) {
//		long now = System.currentTimeMillis();
//		Time sqlTime = new Time(now);
//		System.out.println(sqlTime);
//		String time = services.getTime().toString();
//		System.out.println("aaaaaaa "+time);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		long ms = sdf.parse(time).getTime();
//		Time t = new Time(ms);

//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
//		try {
//			java.sql.Date fajr_begins = (java.sql.Date) formatter.parse(services.getTime());
//			System.out.println(fajr_begins);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		Hi bạn nam
		System.out.println(services.getTime());

//		Time a = new Time(sfd.parse(services.getTime()));
		return null;
	}
	@GetMapping("/services")
	public ResponseEntity<List<Services>>  getAll() {
		long now = System.currentTimeMillis();
		Time sqlTime = new Time(now);
		System.out.println(sqlTime);
		return ResponseEntity.ok().body(iServiceService.findAll());
	}
	@GetMapping("/services/{id}")
	public Services getById(@PathVariable("id") Integer id) {
		return iServiceService.findById(id);
	}

	@PutMapping("/services/{id}")
	public ResponseEntity<Services> update(@PathVariable("id") Integer id , @ModelAttribute Services services) {
		return ResponseEntity.ok(iServiceService.update(services));
	}

	@PutMapping("/services/delete/{id}")
	public ResponseEntity<Services> Delete(@PathVariable("id") Integer id ) {
		Services services = iServiceService.getById(id);
		return ResponseEntity.ok(iServiceService.update(services));
	}
}
