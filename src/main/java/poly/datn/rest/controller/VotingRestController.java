package poly.datn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.datn.entity.Voting;
import poly.datn.service.VotingService;

@RestController
public class VotingRestController {
	
	@Autowired
	VotingService votingService;
	
	@GetMapping("/rest/voting")
	public List<Voting> getAll(){
		return votingService.findAll();
	}

}
