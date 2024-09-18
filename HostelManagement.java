import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

class Student {
    String name;
    String gender;
    Date checkInDate;
    Date checkOutDate;
    int roomNumber;

    public Student(String name, String gender, Date checkInDate, int roomNumber) {
        this.name = name;
        this.gender = gender;
        this.checkInDate = checkInDate;
        this.roomNumber = roomNumber;
    }

    public void checkOut(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public long calculateBill() {
        long diffInMillies = Math.abs(checkOutDate.getTime() - checkInDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        // If stayed for 0 days, consider as 1 day
        if (diffInDays == 0) {
            diffInDays = 1;
        }

        return diffInDays * 300; // 300 rupees per day
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String checkOutStr = (checkOutDate != null) ? dateFormat.format(checkOutDate) : "Still Checked In";
        return "Name: " + name + "\nGender: " + gender + "\nRoom Number: " + roomNumber +
                "\nCheck-in Date: " + dateFormat.format(checkInDate) +
                "\nCheck-out Date: " + checkOutStr;
    }
}

class Hostel {
    ArrayList<Student>[] girlRooms = new ArrayList[5]; // 5 rooms for girls
    ArrayList<Student>[] boyRooms = new ArrayList[5];  // 5 rooms for boys
    int[] girlRoomCapacities = {5, 5, 5, 5, 5};       // Max capacity for each girl room is 5
    int[] boyRoomCapacities = {4, 4, 4, 4, 4};        // Max capacity for each boy room is 4

    public Hostel() {
        for (int i = 0; i < 5; i++) {
            girlRooms[i] = new ArrayList<>();
            boyRooms[i] = new ArrayList<>();
        }
    }

    public void allocateRoom(String name, String gender, Date checkInDate) {
        if (gender.equalsIgnoreCase("female")) {
            for (int i = 0; i < girlRooms.length; i++) {
                if (girlRooms[i].size() < girlRoomCapacities[i]) {
                    Student newStudent = new Student(name, gender, checkInDate, i + 1);
                    girlRooms[i].add(newStudent);
                    System.out.println("Room allocated to girl " + name + " in Room Number: " + (i + 1));
                    return;
                }
            }
            System.out.println("No vacancy for girls.");
        } else if (gender.equalsIgnoreCase("male")) {
            for (int i = 0; i < boyRooms.length; i++) {
                if (boyRooms[i].size() < boyRoomCapacities[i]) {
                    Student newStudent = new Student(name, gender, checkInDate, i + 1);
                    boyRooms[i].add(newStudent);
                    System.out.println("Room allocated to boy " + name + " in Room Number: " + (i + 1));
                    return;
                }
            }
            System.out.println("No vacancy for boys.");
        } else {
            System.out.println("Invalid gender.");
        }
    }

    public void checkOutStudent(String name, String gender, Date checkOutDate) {
        ArrayList<Student>[] rooms = gender.equalsIgnoreCase("female") ? girlRooms : boyRooms;
        for (ArrayList<Student> room : rooms) {
            for (Student student : room) {
                if (student.name.equals(name)) {
                    student.checkOut(checkOutDate);
                    System.out.println(student);
                    System.out.println("Total Bill: " + student.calculateBill() + " rupees");
                    room.remove(student);
                    return;
                }
            }
        }
        System.out.println("Student not found.");
    }
}

public class HostelManagement {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Hostel hostel = new Hostel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        while (true) {
            System.out.println("1. Check-in student");
            System.out.println("2. Check-out student");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter student name:");
                    String name = sc.next();
                    System.out.println("Enter gender (male/female):");
                    String gender = sc.next();
                    System.out.println("Enter check-in date (dd-MM-yyyy):");
                    String checkInStr = sc.next();
                    Date checkInDate = dateFormat.parse(checkInStr);

                    hostel.allocateRoom(name, gender, checkInDate);
                    break;

                case 2:
                    System.out.println("Enter student name:");
                    String nameToCheckOut = sc.next();
                    System.out.println("Enter gender (male/female):");
                    String genderToCheckOut = sc.next();
                    System.out.println("Enter check-out date (dd-MM-yyyy):");
                    String checkOutStr = sc.next();
                    Date checkOutDate = dateFormat.parse(checkOutStr);

                    hostel.checkOutStudent(nameToCheckOut, genderToCheckOut, checkOutDate);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
