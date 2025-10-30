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
        System.out.println("Request from: " + name + " | Thread: " + Thread.currentThread().getName());
        return "Hello, " + name + "!";
    }
    public static void startServer() {
        try {
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/Service", new MyServer());
            System.out.println("Server started successfully.\n");
        } catch (Exception e) {
            System.out.println("Server error: " + e);
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
                    System.out.println(stub.sayHello("Client " + id));
                } catch (Exception e) {
                    System.out.println("Client " + id + " error: " + e);
                }
            }).start();
        }
        try {
            MyService stub = (MyService) Naming.lookup("rmi://localhost:1099/WrongService");
            System.out.println(stub.sayHello("FakeClient"));
        } catch (Exception e) {
            System.out.println("\nTC4 - Server not found: " + e.getClass().getSimpleName());
        }
        try {
            throw new RemoteException("Invalid method call simulated");
        } catch (Exception e) {
            System.out.println("TC5 - Invalid call: " + e.getMessage());
        }
    }
}

