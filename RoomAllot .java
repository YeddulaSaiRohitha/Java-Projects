
import java.util.*;
import java.text.SimpleDateFormat;

public class RoomAllot {
    public static void main(String[] args) {
        int i, j, k, gen, c;
        boolean choice = true;
        Scanner sc = new Scanner(System.in);
        Student g[][] = new Student[5][5]; // Girls' rooms
        Student b[][] = new Student[5][4]; // Boys' rooms

        while (choice) {
            System.out.print("Choose from the Below.\n1.ROOM ENTRY\n2.ROOM EXIT\nChoose a number: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter Boy(0) or Girl(1): ");
                gen = sc.nextInt();
                c = 0;
                if (gen == 1) { // For Girls
                    for (i = 0; i < 5; i++) {
                        for (j = 0; j < 5; j++) {
                            if (g[i][j] == null) {
                                g[i][j] = new Student();
                                g[i][j].details();
                                g[i][j].display();
                                System.out.println("You are allotted in Room No: G" + (i + 1) + "\nYour number in the Room: " + (j + 1));
                                c++;
                                if (c == 1) break;
                            }
                        }
                        if (c == 1) break;
                    }
                    if (c == 0) System.out.println("No vacancies Left.");
                }

                c = 0;
                if (gen == 0) { // For Boys
                    for (i = 0; i < 5; i++) {
                        for (j = 0; j < 4; j++) {
                            if (b[i][j] == null) {
                                b[i][j] = new Student();
                                b[i][j].details();
                                b[i][j].display();
                                System.out.println("You are allotted in Room No: B" + (i + 1) + "\nYour number in the Room: " + (j + 1));
                                c++;
                                if (c == 1) break;
                            }
                        }
                        if (c == 1) break;
                    }
                    if (c == 0) System.out.println("No vacancies Left.");
                }
            } else if (ch == 2) {
                System.out.print("Enter Boy(0) or Girl(1): ");
                gen = sc.nextInt();
                System.out.print("Enter your Room No (1 or 2 or..): ");
                i = sc.nextInt();
                System.out.print("Enter your Number in the Room: ");
                j = sc.nextInt();

                if (gen == 0) { // For Boys
                    if (b[i - 1][j - 1] == null)
                        System.out.println("The specified position is empty.");
                    else {
                        b[i - 1][j - 1].exit();
                        b[i - 1][j - 1].display();
                        b[i - 1][j - 1] = null;
                    }
                }
                if (gen == 1) { // For Girls
                    if (g[i - 1][j - 1] == null)
                        System.out.println("The specified position is empty.");
                    else {
                        g[i - 1][j - 1].exit();
                        g[i - 1][j - 1].display();
                        g[i - 1][j - 1] = null;
                    }
                }
            } else {
                System.out.println("Enter appropriate Choice.");
            }

            System.out.print("Do you want to continue [true] or Exit [false]: ");
            choice = sc.nextBoolean();
        }
    }
}

class Student {
    Scanner sc = new Scanner(System.in);
    String name, id, edt, outdt;
    Date ind, outd;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Enter details for student and date of check-in
    void details() {
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Id No: ");
        id = sc.nextLine();
        System.out.print("Enter Date of Entry (yyyy-mm-dd): ");
        edt = sc.nextLine();
        try {
            ind = new SimpleDateFormat("yyyy-MM-dd").parse(edt);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }

    // Display student information and calculate the bill
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Id No: " + id);
        System.out.println("Date of Entry: " + dateFormat.format(ind));
        if (outd != null) {
            System.out.println("Date of Exit: " + dateFormat.format(outd));
            long n = outd.getTime() - ind.getTime();
            long days = n / (1000 * 60 * 60 * 24); // Milliseconds to days
            if (days == 0) days = 1; // If same day check-in/check-out, count as 1 day
            System.out.println("Amount to be paid: " + (days * 300) + " Rupees");
        }
    }

    // Exit and check-out with date of exit
    void exit() {
        System.out.print("Enter Date of Exit (yyyy-mm-dd): ");
        outdt = sc.nextLine();
        try {
            outd = new SimpleDateFormat("yyyy-MM-dd").parse(outdt);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }
}

import java.util.*;
import java.text.SimpleDateFormat;

public class RoomAllot {
    public static void main(String[] args) {
        int i, j, k, gen, c;
        boolean choice = true;
        Scanner sc = new Scanner(System.in);
        Student g[][] = new Student[5][5]; // Girls' rooms
        Student b[][] = new Student[5][4]; // Boys' rooms

        while (choice) {
            System.out.print("Choose from the Below.\n1.ROOM ENTRY\n2.ROOM EXIT\nChoose a number: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter Boy(0) or Girl(1): ");
                gen = sc.nextInt();
                c = 0;
                if (gen == 1) { // For Girls
                    for (i = 0; i < 5; i++) {
                        for (j = 0; j < 5; j++) {
                            if (g[i][j] == null) {
                                g[i][j] = new Student();
                                g[i][j].details();
                                g[i][j].display();
                                System.out.println("You are allotted in Room No: G" + (i + 1) + "\nYour number in the Room: " + (j + 1));
                                c++;
                                if (c == 1) break;
                            }
                        }
                        if (c == 1) break;
                    }
                    if (c == 0) System.out.println("No vacancies Left.");
                }

                c = 0;
                if (gen == 0) { // For Boys
                    for (i = 0; i < 5; i++) {
                        for (j = 0; j < 4; j++) {
                            if (b[i][j] == null) {
                                b[i][j] = new Student();
                                b[i][j].details();
                                b[i][j].display();
                                System.out.println("You are allotted in Room No: B" + (i + 1) + "\nYour number in the Room: " + (j + 1));
                                c++;
                                if (c == 1) break;
                            }
                        }
                        if (c == 1) break;
                    }
                    if (c == 0) System.out.println("No vacancies Left.");
                }
            } else if (ch == 2) {
                System.out.print("Enter Boy(0) or Girl(1): ");
                gen = sc.nextInt();
                System.out.print("Enter your Room No (1 or 2 or..): ");
                i = sc.nextInt();
                System.out.print("Enter your Number in the Room: ");
                j = sc.nextInt();

                if (gen == 0) { // For Boys
                    if (b[i - 1][j - 1] == null)
                        System.out.println("The specified position is empty.");
                    else {
                        b[i - 1][j - 1].exit();
                        b[i - 1][j - 1].display();
                        b[i - 1][j - 1] = null;
                    }
                }
                if (gen == 1) { // For Girls
                    if (g[i - 1][j - 1] == null)
                        System.out.println("The specified position is empty.");
                    else {
                        g[i - 1][j - 1].exit();
                        g[i - 1][j - 1].display();
                        g[i - 1][j - 1] = null;
                    }
                }
            } else {
                System.out.println("Enter appropriate Choice.");
            }

            System.out.print("Do you want to continue [true] or Exit [false]: ");
            choice = sc.nextBoolean();
        }
    }
}

class Student {
    Scanner sc = new Scanner(System.in);
    String name, id, edt, outdt;
    Date ind, outd;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Enter details for student and date of check-in
    void details() {
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Id No: ");
        id = sc.nextLine();
        System.out.print("Enter Date of Entry (yyyy-mm-dd): ");
        edt = sc.nextLine();
        try {
            ind = new SimpleDateFormat("yyyy-MM-dd").parse(edt);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }

    // Display student information and calculate the bill
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Id No: " + id);
        System.out.println("Date of Entry: " + dateFormat.format(ind));
        if (outd != null) {
            System.out.println("Date of Exit: " + dateFormat.format(outd));
            long n = outd.getTime() - ind.getTime();
            long days = n / (1000 * 60 * 60 * 24); // Milliseconds to days
            if (days == 0) days = 1; // If same day check-in/check-out, count as 1 day
            System.out.println("Amount to be paid: " + (days * 300) + " Rupees");
        }
    }

    // Exit and check-out with date of exit
    void exit() {
        System.out.print("Enter Date of Exit (yyyy-mm-dd): ");
        outdt = sc.nextLine();
        try {
            outd = new SimpleDateFormat("yyyy-MM-dd").parse(outdt);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }
}
