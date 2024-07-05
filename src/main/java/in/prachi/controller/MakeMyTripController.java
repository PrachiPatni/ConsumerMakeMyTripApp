package in.prachi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.prachi.bindings.Passenger;
import in.prachi.bindings.Ticket;
import in.prachi.service.MakeMyTripService;

@Controller
public class MakeMyTripController {

	@Autowired
	private MakeMyTripService service;
	@GetMapping("/book-ticket")
	public String bookTicket(Model model) {
		//form binding
		model.addAttribute("p", new Passenger());
		return "bookTicket";
	}
	
	@GetMapping("/")
	//model is used to send the data from controller to UI
	public String index(Model model) {
		//fetching the alltickets from service
		List<Ticket> allTickets = service.getAllTickets();
		//sending the data to the ui
		model.addAttribute("tickets",allTickets);
		return "index";
	}
	
}
