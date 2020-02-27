import java.net.ServerSocket;
import java.net.Socket;

public class accept_client_thread extends Thread {
    ServerSocket server;
    public accept_client_thread(ServerSocket socket)
    {
        server = socket;
        start();
    }

    public void run() {
        try {

            while (true) {
                Socket socket = server.accept();
                chat_with_client_thread client_thread = new chat_with_client_thread(socket);
                Server.client_threads.add(client_thread);
            }



        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
