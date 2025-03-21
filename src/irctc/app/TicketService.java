package irctc.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class TicketService {
	static Long pNRNo=001L;
	static Integer seatNumber = 1;
	static List<PassengerDto> confirmedTicketList = new ArrayList<>();// Total-63
	static Queue<PassengerDto> waitingListQueue= new LinkedList<>();
	static Queue<PassengerDto> rACQueue=new LinkedList<>();
	static int upperBirth = 1, middleBirth = 1, lowerBirth = 1;// seats 63 % 3 = 21

	public static String bookTicket(PassengerDto passengerDto) {
		if(lowerBirth != 0||middleBirth != 0||upperBirth != 0) {
		if (passengerDto.getPreferBirth().equalsIgnoreCase("L") && lowerBirth != 0) {
			passengerDto.setSeatNumber(seatNumber + "L");
			passengerDto.setStatus("Confirmed");
			lowerBirth--;
		} else if (passengerDto.getPreferBirth().equalsIgnoreCase("M") && middleBirth != 0) {
			passengerDto.setSeatNumber(seatNumber + "M");
			passengerDto.setStatus("Confirmed");
			middleBirth--;
		} else if (passengerDto.getPreferBirth().equalsIgnoreCase("U") && upperBirth != 0) {
			passengerDto.setSeatNumber(seatNumber + "U");
			passengerDto.setStatus("Confirmed");
			upperBirth--;
		} else  {
			if (lowerBirth != 0) {
				passengerDto.setSeatNumber(seatNumber + "L");
				passengerDto.setStatus("Confirmed");
				lowerBirth--;
			} else if (middleBirth != 0) {
				passengerDto.setSeatNumber(seatNumber + "M");
				passengerDto.setStatus("Confirmed");
				middleBirth--;
			} else {
				passengerDto.setSeatNumber(seatNumber + "U");
				passengerDto.setStatus("Confirmed");
				upperBirth--;
			}

		}
		passengerDto.setpNRNo(pNRNo++);
		confirmedTicketList.add(passengerDto);
		return "Ticket Confirmed";
		}else {	
			passengerDto.setStatus("RAC");
			rACQueue.add(passengerDto);
		return "No Ticket Available";
		}
	}
	
	public static String cancelTicket(Long pnrNo) {
		Optional<PassengerDto> psgOptional=confirmedTicketList.stream().filter(obj->obj.getpNRNo().equals(pnrNo)).findFirst();
		if(!psgOptional.isEmpty()) {
			PassengerDto passengerDto=psgOptional.get();
			confirmedTicketList.remove(passengerDto);
			return "TicketCancelled";
		}else {
			return "InvalidPNR-No";
		}
	}
	
	public static List<PassengerDto> viewTickets(){
		return confirmedTicketList;
	}
}
