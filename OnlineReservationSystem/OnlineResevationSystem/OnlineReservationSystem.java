import java.util.*;

public class OnlineReservationSystem
{
    static Scanner scn = new Scanner(System.in);
    static Map<String, String> users = new HashMap<>();
    static Map<String, String> reservations = new HashMap<>();

    public static void main(String[] args)
    {
        // Booking  sample credentials
        users.put("passenger1", "12345");

        System.out.println("***** Welcome to Online Reservation System ******");

        if (login())
        {
            int choice;
            do {
                System.out.println("\n1. Reserve Ticket");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scn.nextInt();
                scn.nextLine(); // clear input buffer

                switch (choice) {
                    case 1 -> reserveTicket();
                    case 2 -> cancelTicket();
                    case 3 -> System.out.println("Thank you for using the system!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 3);
        }
        else
        {
            System.out.println("your Login was failed. Exiting system.");
        }
    }

    static boolean login()
    {
        System.out.print("Enter Login ID: ");
        String loginId = scn.nextLine();
        System.out.print("Enter Password: ");
        String password = scn.nextLine();

        return users.containsKey(loginId) && users.get(loginId).equals(password);
    }

    static void reserveTicket()
    {
        System.out.print("Enter Your Name: ");
        String name = scn.nextLine();
        System.out.print("Enter Train Number: ");
        String trainNumber = scn.nextLine();
        System.out.print("Enter Train Name: ");
        String trainName = scn.nextLine();
        System.out.print("Enter Class Type (e.g., Sleeper/AC): ");
        String classType = scn.nextLine();
        System.out.print("Enter Date of Journey (DD-MM-YYYY): ");
        String dateOfJourney = scn.nextLine();
        System.out.print("From Station: ");
        String from = scn.nextLine();
        System.out.print("To Station: ");
        String to = scn.nextLine();

        String pnr = "PNR" + (1000 + new Random().nextInt(9000)); // Random PNR genarator
        String ticketDetails = "Name: " + name + "\nTrain No: " + trainNumber + "\nTrain Name: " + trainName +
                "\nClass: " + classType + "\nDate: " + dateOfJourney + "\nFrom: " + from + "\nTo: " + to;

        reservations.put(pnr, ticketDetails);

        System.out.println("\n Ticket was Booked Successfully \n --- thank you booking ");
        System.out.println("Your PNR NUMBER IS: " + pnr);
        System.out.println("your Ticket Details are :\n" + ticketDetails);
    }

    static void  cancelTicket()
    {
        System.out.print("Enter your PNR Number to cancel ticket: ");
        String pnr = scn.nextLine();
        if (reservations.containsKey(pnr))
        {
            System.out.println("your Ticket was  Found:\n" + reservations.get(pnr));
            System.out.print("Type 'OK' to confirm cancellation: ");
            String confirm = scn.nextLine();
            if (confirm.equalsIgnoreCase("OK"))
            {
                reservations.remove(pnr);
                System.out.println(" Ticket was Cancelled Successfully.");
            }
            else
            {
                System.out.println("Cancellation Aborted.");
            }
        }
        else {
            System.out.println("Oops No ticket found with PNR: " + pnr);
        }
    }
}

