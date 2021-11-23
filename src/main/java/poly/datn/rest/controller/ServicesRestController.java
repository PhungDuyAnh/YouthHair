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
	public Services create(@RequestBody ServiceDTO serviceDTO) {
		return iServiceService.save(serviceDTO);
	}
	@GetMapping("/services")
	public ResponseEntity<List<Services>>  getAll() {
		return ResponseEntity.ok().body(iServiceService.findAll());
	}
	@GetMapping("/services/{id}")
	public Services getById(@PathVariable("id") Integer id) {
		return iServiceService.getById(id);
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
