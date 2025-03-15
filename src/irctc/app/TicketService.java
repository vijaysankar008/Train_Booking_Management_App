package irctc.app;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
	static Integer seatNumber = 1;
	static List<PassengerDto> confirmedTicketList = new ArrayList<>();// Total-63
	static int upperBirth = 1, middleBirth = 0, lowerBirth = 0;// seats 63 % 3 = 21

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
		confirmedTicketList.add(passengerDto);
		return "Ticket Confirmed";
		}else {	
			
		return "No Ticket Available";
		}
	}
}
