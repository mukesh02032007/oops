import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server started, waiting for clients...");

            while (true) { // keep server running
                Socket s = ss.accept();
                System.out.println("Client connected.");

                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                String clientMsg = dis.readUTF();
                System.out.println("Client says: " + clientMsg);

                dos.writeUTF("Hello Client, message received!");

                dis.close();
                dos.close();
                s.close();
                System.out.println("Client disconnected.\nWaiting for next client...");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
	}
}
import java.io.*;
import java.net.*;
public class Client {
	public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 5000);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            dos.writeUTF("Hello Server!");

            String serverMsg = dis.readUTF();
            System.out.println("Server says: " + serverMsg);

            dis.close();
            dos.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
	}
}
