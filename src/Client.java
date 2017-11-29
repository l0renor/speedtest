import java.net.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Client {

        public static void main(String[] args) throws Exception {

            int n = 100;
            int k = 5;
            int PORT = 4001;
            byte[] buf = new byte[1400];
            Arrays.fill(buf,(byte)1);
            DatagramSocket sk;


            sk = new DatagramSocket(PORT);
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
                System.out.println(i);
            }
            double rate = (i/30)*1.4;
            System.out.println(rate + " kb/s");
        }
    }

