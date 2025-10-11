package Assignment;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
public class NIOChatServer {
	public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(5000));
            server.configureBlocking(false);
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server started on port 5000...");

            while (true) {
                selector.select();
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    keys.remove();

                    try {
                        if (key.isAcceptable()) {
                            SocketChannel client = server.accept();
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);
                            System.out.println("Client connected: " + client.getRemoteAddress());
                        } 
                        else if (key.isReadable()) {
                            SocketChannel client = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(256);
                            int read = client.read(buffer);
                            if (read == -1) {
                                client.close();
                                System.out.println("Client disconnected.");
                                continue;
                            }
                            String msg = new String(buffer.array()).trim();
                            System.out.println("Received: " + msg);

                            // Broadcast to all clients
                            for (SelectionKey k : selector.keys()) {
                                if (k.channel() instanceof SocketChannel && k.isValid()) {
                                    SocketChannel ch = (SocketChannel) k.channel();
                                    if (ch != client) {
                                        ch.write(ByteBuffer.wrap(("Broadcast: " + msg).getBytes()));
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        key.cancel();
                        try { key.channel().close(); } catch (IOException ex) {}
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
	}
}

package Assignment;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
public class NIOChatClient {
	public static void main(String[] args) {
        try {
            SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 5000));
            System.out.println("Connected to chat server.");
            Scanner sc = new Scanner(System.in);

            // Thread to listen for incoming messages
            new Thread(() -> {
                ByteBuffer buffer = ByteBuffer.allocate(256);
                try {
                    while (true) {
                        buffer.clear();
                        int read = client.read(buffer);
                        if (read == -1) break;
                        System.out.println(new String(buffer.array()).trim());
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            }).start();

            // Main thread to send messages
            while (true) {
                String msg = sc.nextLine();
                client.write(ByteBuffer.wrap(msg.getBytes()));
            }
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
	}
}



