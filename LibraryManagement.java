import java.util.*;

public class LibraryManagement {
    public static void main(String[] args) {

        // List - stores books
        List<String> books = new ArrayList<>();
        books.add("Java Programming");
        books.add("Data Structures");
        books.add("Computer Networks");

        // Set - stores unique members
        Set<String> members = new HashSet<>();
        members.add("Riya");
        members.add("Rahul");
        members.add("Anu");

        // Map - book and its availability
        Map<String, Boolean> availability = new HashMap<>();
        availability.put("Java Programming", true);
        availability.put("Data Structures", true);
        availability.put("Computer Networks", false);

        // Queue - waiting list
        Queue<String> waitingList = new LinkedList<>();
        waitingList.add("Ron");
        waitingList.add("Priya");

        System.out.println("Books: " + books);
        System.out.println("Members: " + members);
        System.out.println("Book Availability: " + availability);
        System.out.println("Waiting List: " + waitingList);

        // Issue a book
        String book = "Java Programming";

        if (availability.get(book)) {
            availability.put(book, false);
            System.out.println(book + " issued successfully.");
        } else {
            System.out.println(book + " is not available.");
        }

        // Serve waiting list
        System.out.println("Next member in waiting list: "
                           + waitingList.poll());
    }
}
