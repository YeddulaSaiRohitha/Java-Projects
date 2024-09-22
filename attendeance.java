import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class AttendanceRecord {
    private String username;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private boolean checkedIn;

    AttendanceRecord(String username) {
        this.username = username;
        this.checkedIn = false;
    }

    void checkIn() {
        if (!checkedIn) {
            checkedIn = true;
            checkInTime = LocalDateTime.now();
            System.out.println(username + " checked in at " + formatTime(checkInTime));
        } else {
            System.out.println(username + " is already checked in at " + formatTime(checkInTime));
        }
    }

    void checkOut() {
        if (checkedIn) {
            checkedIn = false;
            checkOutTime = LocalDateTime.now();
            System.out.println(username + " checked out at " + formatTime(checkOutTime));
        } else {
            System.out.println(username + " is not checked in.");
        }
    }

    String getAttendanceDetails() {
        if (checkedIn) {
            return username + " is currently checked in at " + formatTime(checkInTime) + ".";
        } else {
            return username + " is absent.";
        }
    }

    private String formatTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}

public class AttendanceSystem {
    private static HashMap<String, User> users = new HashMap<>();
    private static HashMap<String, AttendanceRecord> attendanceRecords = new HashMap<>();

    public static void main(String[] args) {
        // Sample Users
        users.put("employee1", new User("employee1", "password1"));
        users.put("employee2", new User("employee2", "password2"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Attendance Management System");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Authentication
        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            System.out.println("Login successful!");

            AttendanceRecord record = attendanceRecords.getOrDefault(username, new AttendanceRecord(username));
            attendanceRecords.put(username, record);

            while (true) {
                System.out.println("Enter 'checkin' to check in, 'checkout' to check out, 'status' to check attendance details, or 'exit' to quit:");
                String command = scanner.nextLine();

                if (command.equalsIgnoreCase("checkin")) {
                    record.checkIn();
                } else if (command.equalsIgnoreCase("checkout")) {
                    record.checkOut();
                } else if (command.equalsIgnoreCase("status")) {
                    System.out.println(record.getAttendanceDetails());
                } else if (command.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid command.");
                }
            }
        } else {
            System.out.println("Invalid username or password.");
        }

        scanner.close();
    }
}
