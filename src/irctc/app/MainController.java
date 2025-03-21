package irctc.app;

import java.util.Scanner;

public class MainController {
	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("**********Welcome to IRCTC*************/");
		boolean key = true;
		do {
			System.out.println("\n1.Book Ticket\n2.Cancel Ticket\n3.View Ticket\n4.Exit");
			System.out.println("Choose Any one Option....");
			int optionValue = userInput.nextInt();
			switch (optionValue) {
			case 1: {// 1.Book Ticket
				PassengerDto passenger = new PassengerDto();
				System.out.println("Enter the name....");
				passenger.setName(userInput.next());
				System.out.println("Enter your age...");
				passenger.setAge(userInput.nextInt());
				System.out.println("Enter your gender...");
				passenger.setGender(userInput.next());
				System.out.println("Select your preffered Birth...U|M|L");
				passenger.setPreferBirth(userInput.next());
				// System.out.println(passenger);
				String result = TicketService.bookTicket(passenger);
				System.out.println(result);
				System.out.println();
				break;
			}
			case 2:{//2.Cancel Ticket
				System.out.println("Enter Your PNR-No to cancel your Ticket...");
				Long pnrNo=(Long)userInput.nextLong();
				System.out.println(TicketService.cancelTicket(pnrNo));
				break;
			}
			case 3:{//3.View Ticket
				System.out.println(TicketService.viewTickets());
				break;
			}
			}
		} while (true);
	}
}
