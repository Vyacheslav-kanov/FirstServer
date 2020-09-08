import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.net.SocketException;

public class Client {

    static final int port = 8181;
    static final String host = "Localhost";
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()))) {
            out.println( "GET / HTTP/1.1\n" +
                    "Host: Localhost\n\n\n");
            out.println("Hello Server!");

            System.out.println(in.readLine());
        }catch (IOException e){
            System.out.println("Соединение разорвано!");
        }
    }
}
