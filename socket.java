package oops;
import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TC1: Server started on port " + port);
            int clientCount = 0;
            while (clientCount < 5) { 
                System.out.println("TC5: Waiting for client...");
                Socket clientSocket = serverSocket.accept();
                clientCount++;
                System.out.println("TC5: Client " + clientCount + " connected.");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String clientMessage = in.readLine();
                System.out.println("TC3: Received from client: " + clientMessage);
                String reply = "Server reply: " + clientMessage.toUpperCase();
                out.println(reply);
                System.out.println("TC4: Reply sent to client.");
                clientSocket.close();
                System.out.println("TC5: Client " + clientCount + " disconnected.\n");
            }
        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
	}
}





package oops;
import java.io.*;
import java.net.*;
public class Client {
	public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;
        try (Socket socket = new Socket(host, port)) {
            System.out.println("TC1: Connected to server at " + host + ":" + port);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.print("Enter message to send: ");
            String message = input.readLine();
            out.println(message);
            System.out.println("TC3: Message sent: " + message);
            String response = in.readLine();
            System.out.println("TC4: Received from server: " + response);
        } catch (ConnectException ce) {
            System.out.println("TC2: Connection refused: Server may not be running.");
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
	}
}

