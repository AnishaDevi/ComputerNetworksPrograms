import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPServer {
    public static void main(String args[])throws Exception
    {
        System.out.println("Sender");
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message:");
        while(true)
        {
            String msg = sc.nextLine();
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.length(),ip,3000);
            ds.send(dp);
        }
    }
}
