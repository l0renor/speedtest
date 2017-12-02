import java.io.DataOutputStream;
import java.net.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Client {

        public static void main(String[] args) throws Exception {
            sendTCP(10000,2);


        }

    public static void sendUDP()throws Exception{

        int n = 100;
        int k = 5;
        byte[] buf = new byte[1400];
        Arrays.fill(buf,(byte)1);
        DatagramSocket sk;


        sk = new DatagramSocket(4005);
        InetAddress hostAddress = InetAddress.getLocalHost();
        long start = System.currentTimeMillis();
        int i = 0;
        while (start - System.currentTimeMillis() > -30000){
            i++;
            DatagramPacket out = new DatagramPacket(buf, buf.length,hostAddress,4000);
            sk.send(out);
            if(i%n == 0){
                TimeUnit.MICROSECONDS.sleep(k);
            }

        }
        double rate = (i/30)*1.4;
        System.out.println(rate + " kb/s");

    }

    public static void sendTCP(int n ,int k)throws Exception{

        int PORT = 4001;
        byte[] buf = new byte[1400];
        Arrays.fill(buf,(byte)1);
        InetAddress hostAddress = InetAddress.getLoopbackAddress();
        Socket s = new Socket(hostAddress,4001);

        DataOutputStream dOut = new DataOutputStream(s.getOutputStream());




        long start = System.currentTimeMillis();
        int i = 0;
        while (start - System.currentTimeMillis() > -30000){
            i++;
            dOut.write(buf);
            dOut.flush();
            if(i%n == 0){
                TimeUnit.MICROSECONDS.sleep(k);
            }

        }
        double rate = (i/30)*1.4;
        System.out.println(i);
        System.out.println(rate + " kb/s");

    }

    }

