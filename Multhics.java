package oops;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
interface MyService extends Remote {
    String sayHello(String name) throws RemoteException;
}
class MyServer extends UnicastRemoteObject implements MyService {
    MyServer() throws RemoteException { super(); }

    public String sayHello(String name) throws RemoteException {
        System.out.println("[TC2/TC3] Request received from: " + name +
                           " | Handled by Thread: " + Thread.currentThread().getName());
        return "Hello, " + name + "!";
    }
    public static void startServer() {
        try {
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/Service", new MyServer());
            System.out.println("=== TC1: Server started successfully ===\n");
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}
public class Multhics{
    public static void main(String[] args) {
        new Thread(() -> MyServer.startServer()).start();
        try { Thread.sleep(1000); } catch (Exception e) {}
        for (int i = 1; i <= 3; i++) {
            final int id = i;
            new Thread(() -> {
                try {
                    MyService stub = (MyService) Naming.lookup("rmi://localhost:1099/Service");
                    String response = stub.sayHello("Client " + id);
                    System.out.println("[TC2/TC3] Response: " + response);
                } catch (Exception e) {
                    System.out.println("[TC2/TC3] Client " + id + " Error: " + e);
                }
            }).start();
        }
        try {
            MyService wrongStub = (MyService) Naming.lookup("rmi://localhost:1099/WrongService");
            System.out.println(wrongStub.sayHello("FakeClient"));
        } catch (Exception e) {
            System.out.println("\n=== TC4: Server not found or wrong lookup ===");
            System.out.println("Error: " + e.getClass().getSimpleName() + "\n");
        }
        try {
            throw new RemoteException("Invalid method call simulated");
        } catch (Exception e) {
            System.out.println("=== TC5: Invalid method call handled ===");
            System.out.println("Error Message: " + e.getMessage());
        }
    }
}
