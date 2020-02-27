import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class chat_with_client_thread extends Thread {
    String name;
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    Scanner scanner = new Scanner(System.in);

    public chat_with_client_thread(Socket socket) throws Exception
    {
        this.socket = socket;

        out = new ObjectOutputStream( socket.getOutputStream() );
        in = new ObjectInputStream( socket.getInputStream() );

        name = (String)in.readObject();

        System.out.println((String)name + " joined");

        start();
    }

    public void run() {
        try {

            while (true) {
                String msg = (String)in.readObject();

                System.out.println(msg);

                String [] spit_msg = msg.split(" ", 2);
                System.out.println(spit_msg[0]);
                System.out.println(spit_msg[1]);

                for(int i=0;i<Server.client_threads.size();i++)
                {
                    if(Server.client_threads.get(i).name.equals(spit_msg[0]))
                    {
                        Server.client_threads.get(i).out.writeObject(this.name + " : " + spit_msg[1]);
                        break;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
