import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashAlgorithmExample {

    // Method to generate SHA-256 hash
    public static String generateHash(String input) {
        try {
            // Step 1: Choose Hash Algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Step 2: Convert input string to byte array
            byte[] hashBytes = md.digest(input.getBytes());

            // Step 3: Convert byte array into hexadecimal format
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: Algorithm not found", e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input message
        System.out.print("Enter message: ");
        String message = scanner.nextLine();

        // Generate hash
        String hashValue = generateHash(message);

        // Output result
        System.out.println("Hash Value (SHA-256): " + hashValue);

        scanner.close();
    }
}
