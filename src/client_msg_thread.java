import java.io.IOException;
import java.io.ObjectInputStream;

public class client_msg_thread extends Thread {
    ObjectInputStream in;
    public client_msg_thread(ObjectInputStream in)
    {
        this.in = in;
        start();
    }

    public void run()
    {

        while (true)
        {
            try {
                System.out.println( (String)in.readObject() );
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
