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

