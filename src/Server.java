import java.net.ServerSocket;
import java.util.ArrayList;

public class Server {

    public static ArrayList<chat_with_client_thread> client_threads = new ArrayList<chat_with_client_thread>();
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);

        new accept_client_thread(serverSocket);


    }
}
