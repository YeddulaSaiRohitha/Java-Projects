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
        this.checkInTime = null;
        this.checkOutTime = null;
    }

    void checkIn() {
        if (!checkedIn) {
            checkedIn = true;
            checkInTime = LocalDateTime.now();
            checkOutTime = null; // Reset check-out time upon new check-in
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
        if (checkInTime == null) {
            return username + " is absent.";
        } else if (checkedIn) {
            return username + " is currently checked in at " + formatTime(checkInTime) + ".";
        } else if (checkOutTime != null) {
            return username + " checked out at " + formatTime(checkOutTime) + ".";
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
        users.put("employee3", new User("employee3", "password3"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Attendance Management System");

        while (true) {
            System.out.print("Enter username to login (or type 'exit' to quit): ");
            String username = scanner.nextLine();
            if (username.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // Authentication
            User user = users.get(username);
            if (user != null && user.password.equals(password)) {
                System.out.println("Login successful!");

                AttendanceRecord record = attendanceRecords.getOrDefault(username, new AttendanceRecord(username));
                attendanceRecords.put(username, record);

                while (true) {
                    System.out.println("Enter 'checkin' to check in, 'checkout' to check out, 'status' to check attendance details, 'logout' to log out, or 'exit' to quit:");
                    String command = scanner.nextLine();

                    if (command.equalsIgnoreCase("checkin")) {
                        record.checkIn();
                    } else if (command.equalsIgnoreCase("checkout")) {
                        record.checkOut();
                    } else if (command.equalsIgnoreCase("status")) {
                        System.out.println(record.getAttendanceDetails());
                    } else if (command.equalsIgnoreCase("logout")) {
                        System.out.println(username + " logged out.");
                        break;
                    } else if (command.equalsIgnoreCase("exit")) {
                        System.out.println("Exiting...");
                        return; // Exit the entire system
                    } else {
                        System.out.println("Invalid command.");
                    }
                }
            } else {
                System.out.println("Invalid username or password.");
            }
        }

        // Display final attendance details for all users
        System.out.println("\nFinal attendance details for all users:");
        for (String userKey : attendanceRecords.keySet()) {
            AttendanceRecord record = attendanceRecords.get(userKey);
            System.out.println(record.getAttendanceDetails());
        }

        scanner.close();
    }
}
