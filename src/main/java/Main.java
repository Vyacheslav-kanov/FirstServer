import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    static int port = 8081;
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Ожидание подключение...");
            Socket socket = serverSocket.accept();
            System.out.println("Есть контакт!");

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, socket.getPort()));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
