import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        int port = 8080; // Specify the port you want to listen on

        // Create a new ServerSocket object and bind it to localhost
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost", port));

        // Loop forever, waiting for incoming connections
        while (true) {
            System.out.println("Waiting for connection...");

            // Wait for an incoming client connection
            Socket clientSocket = serverSocket.accept();

            // Handle the incoming client connection in a new thread
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            System.out.println("Connection accepted from " + clientSocket.getInetAddress());

            // Handle the incoming client connection here

            // Close the client socket
            clientSocket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
