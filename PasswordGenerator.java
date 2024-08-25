import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private static final String ALL_CHARS = LOWER + UPPER + DIGITS + SPECIAL;

    public static void main(String[] args) {
        int length = 12; // Length of the password
        System.out.println("Generated Password: " + generatePassword(length));
    }

    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALL_CHARS.length());
            password.append(ALL_CHARS.charAt(index));
        }

        return password.toString();
    }
}
