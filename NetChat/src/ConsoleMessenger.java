import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ConsoleMessenger {
    protected Socket socket;
    protected DataOutputStream out;
    protected DataInputStream in;
    protected InputStream printer = System.in;
    protected PrintStream writer= System.out;
    protected BufferedReader reader = new BufferedReader(new InputStreamReader(printer));

    protected void sendMessage(String msg) throws IOException {
        out.writeUTF(msg);
    }

    protected void printMessage(String msg) throws IOException {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        writer.print(df.format(new Date()) + ">>> " + msg);
        writer.println();
    }

    protected void initMessaging() {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String msg = in.readUTF();
                            printMessage(msg);
                            if (msg.equals("/end"))
                                break;
                        }
                    } catch (IOException e) {
                        System.out.println("Connection stopped.");
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String s = reader.readLine();
                            if (s != null && !s.equals(""))
                                sendMessage(s);
                            if (s.equals("/end")) break;
                        }
                    } catch (IOException e) {
                        System.out.println("Connection stopped.");
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (ConnectException e) {
            System.out.println("Connection error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
