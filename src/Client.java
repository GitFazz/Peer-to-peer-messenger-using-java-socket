import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws  Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("put your username - ");
        String uname = scanner.nextLine();

        Socket socket = new Socket("127.0.0.1",6666);
        ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );
        ObjectInputStream in = new ObjectInputStream( socket.getInputStream() );

        out.writeObject( (Object) uname );

        new client_msg_thread(in);


        while (true) {

            try {
                while (true) {

                    String msg = scanner.nextLine();
                    out.writeObject((Object) msg);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
