package poly.datn.rest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poly.datn.entity.Services;
import poly.datn.service.IServiceService;

import java.util.List;

@RestController
@RequestMapping("/poly")
public class ServicesRestController {

	//    private final ServicesService servicesService;
//
//    private final ServiceDAO serviceDAO;
//
//    public ServiceController(ServicesService servicesService, ServiceDAO serviceDAO){
//
//        this.servicesService = servicesService;
//        this.serviceDAO = serviceDAO;
//    }
	//
	//    @PostMapping("/services")
	//    public ResponseEntity<Services> create(@Valid @RequestBody ServiceDTO serviceDTO) throws URISyntaxException {
	//        Services services = servicesService.create(serviceDTO);
	//
	//        return ResponseEntity.ok().body(services);
	//    }
	//
	//    @GetMapping("/services")
	//    public ResponseEntity<Page<ServiceDTO>> getAllCortusers(Pageable pageable) {
	//        Page<ServiceDTO> page =servicesService.findAll(pageable);
	//        return ResponseEntity.ok().body(page);
	//    }
	@Autowired
	IServiceService iServiceService;
	@PostMapping("/services")
	public ResponseEntity <Services> create(@ModelAttribute Services services) {
//        iServiceService.save(services);
		return ResponseEntity.ok(iServiceService.save(services));
	}
	@GetMapping("/services")
	public ResponseEntity<List<Services>>  getAll() {
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
