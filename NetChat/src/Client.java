import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Client extends ConsoleMessenger {
    final static String SERVER_IP = "localhost";
    final static int SERVER_PORT = 8190;

    public Client(String SERVER_IP, int SERVER_PORT) {
        System.out.println("Client is running...");
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected to server.");
        } catch (ConnectException e) {
                System.out.println("Connection stopped.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        initMessaging();
    }

    public static void main(String[] args) {
        new Client(SERVER_IP, SERVER_PORT);
    }
}
