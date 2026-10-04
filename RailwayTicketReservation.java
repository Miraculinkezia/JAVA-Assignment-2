import java.util.*;

class InvalidTrainException extends Exception {
    InvalidTrainException(String msg) { super(msg); }
}

class NoSeatsException extends Exception {
    NoSeatsException(String msg) { super(msg); }
}

class InvalidPassengerException extends Exception {
    InvalidPassengerException(String msg) { super(msg); }
}

class InvalidTicketException extends Exception {
    InvalidTicketException(String msg) { super(msg); }
}

class Train {
    int trainNo, seats;
    String name, from, to;

    Train(int no, String n, String f, String t, int s) {
        trainNo = no;
        name = n;
        from = f;
        to = t;
        seats = s;
    }

    void display() {
        System.out.println(trainNo + " " + name + " " + from + " -> " + to
                           + " Seats: " + seats);
    }
}

public class RailwayTicketReservation {
    static Scanner sc = new Scanner(System.in);
    static Train[] trains = {
        new Train(101, "Chennai Express", "Chennai", "Bangalore", 2),
        new Train(102, "Coimbatore Express", "Chennai", "Coimbatore", 3)
    };

    static int ticketNo = 1000;
    static Set<Integer> bookedTickets=new HashSet<>();

    static Train findTrain(int no) throws InvalidTrainException {
        for (Train t : trains)
            if (t.trainNo == no)
                return t;

        throw new InvalidTrainException("Invalid train number!");
    }

    static void bookTicket() {
        try {
            System.out.print("Enter train number: ");
            int no = sc.nextInt();

            Train t = findTrain(no);

            if (t.seats <= 0)
                throw new NoSeatsException("No seats available!");

            sc.nextLine();
            System.out.print("Enter passenger name: ");
            String name = sc.nextLine();

            if (name.trim().isEmpty())
                throw new InvalidPassengerException("Invalid passenger details!");

            t.seats--;
            ticketNo++;
            bookedTickets.add(ticketNo);

            System.out.println("Ticket booked successfully!");
            System.out.println("Ticket Number: " + ticketNo);
            System.out.println("Passenger: " + name);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void cancelTicket() {
        try {
            System.out.print("Enter ticket number: ");
            int no = sc.nextInt();

            if (!bookedTickets.contains(no))
                throw new InvalidTicketException("Invalid ticket number!");

            System.out.println("Ticket cancelled successfully!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. Search Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Train t : trains)
                        t.display();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelTicket();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}