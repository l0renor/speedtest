import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import java.net.SocketTimeoutException;


public class ServerUDP {


    public static void main(String[] args) throws Exception {

        DatagramSocket s = new DatagramSocket(4000);
        s.setSoTimeout(5000);
        byte[] buf = new byte[1400];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        int i = 0;
        try{
        while (true) {


            s.receive(dp);

            i++;
            System.out.println(i);
        }
        } catch(SocketTimeoutException e){
            double rate = (i/30)*1.4;
            System.out.println(rate+" kb/s");
        }
    }
}
