import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 1234;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started...");

        while (true) {
            Socket client = serverSocket.accept();
            clients.add(client);
            System.out.println("New client connected: " + client);
            new Thread(new ClientHandler(client)).start();
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    for (Socket s : clients) {
                        if (s != socket) {
                            new PrintWriter(s.getOutputStream(), true).println("Client says: " + message);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Client disconnected.");
            }
        }
    }
}
