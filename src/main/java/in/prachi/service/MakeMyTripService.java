package in.prachi.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.prachi.bindings.Passenger;
import in.prachi.bindings.Ticket;
@Service
public class MakeMyTripService {

	public Ticket bookTicket(Passenger p) {
		String apiUrl="http://3.83.106.158:8080/ticket";
		RestTemplate rt= new RestTemplate();
		ResponseEntity<Ticket> forEntity =
				rt.postForEntity("apiUrl", p, Ticket.class);
	
	Ticket body	=forEntity.getBody();
	return body;
	}
	
	public List<Ticket>getAllTickets(){
		String apiUrl="http://3.83.106.158:8080/passengers";
		RestTemplate rt= new RestTemplate();
		ResponseEntity<Ticket[]> forEntity =
				rt.getForEntity(apiUrl,Ticket[].class);
		Ticket[] body = forEntity.getBody();
		List<Ticket> tickets = Arrays.asList(body);
		return tickets;
	}
}
