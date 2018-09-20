import java.io.IOException;
import java.net.ServerSocket;

public class Server  extends ConsoleMessenger {

    public Server(int port) {
        try( ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running...");
            this.socket = serverSocket.accept();
            System.out.println("Client connected");
            initMessaging();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Server(8190);
    }
}
