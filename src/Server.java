import java.io.InputStream;
import java.net.*;



public class Server {


    public static void main(String[] args) throws Exception {
        reciveTCP();


    }

    public static void reciveUDP() throws Exception {

        DatagramSocket s = new DatagramSocket(4000);
        s.setSoTimeout(5000);
        byte[] buf = new byte[1400];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        int i = 0;
        try{
            while (true) {


                s.receive(dp);

                i++;
            }
        } catch(SocketTimeoutException e){
            double rate = (i/30)*1.4;
            System.out.println(rate+" kb/s");
        }


    }

    public static void reciveTCP() throws Exception {

        ServerSocket ss = new ServerSocket(4001);

        byte[] buf = new byte[1400];
        System.out.println("Waiting to connect");
        Socket s = ss.accept();
        System.out.println("Connected");
        InputStream is =  s.getInputStream();
        s.setSoTimeout(5000);
        long i = 0;
        try{
            while (true) {


                  i += (is.read(buf)/1000);



            }
        } catch(Exception e){
            System.out.println(i);
            double rate = (i/30);
            System.out.println(rate+" kb/s");
        }


    }
}
