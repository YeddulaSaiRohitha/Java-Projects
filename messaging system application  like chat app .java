// ChatServer.java

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static List<Socket> clients = new ArrayList<>();  // List of connected clients

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);  // Start server on port 12345
        System.out.println("Server is running...");

        while (true) {
            // Accept new client
            Socket clientSocket = serverSocket.accept();
            clients.add(clientSocket);
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            // Handle client in a new thread
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    // Handle incoming messages from clients
    private static void handleClient(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                broadcastMessage(message);
            }
        } catch (IOException e) {
            System.out.println("Client disconnected: " + clientSocket.getRemoteSocketAddress());
        }
    }

    // Broadcast message to all connected clients
    private static void broadcastMessage(String message) throws IOException {
        for (Socket client : clients) {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println(message);
        }
    }
}


//  ChatClient.java

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);  // Connect to server
        System.out.println("Connected to the server!");

        // Thread to read incoming messages
        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Message from server: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Send messages to the server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String message = scanner.nextLine();  // Read input from user
            out.println(message);  // Send to server
        }
    }
}
