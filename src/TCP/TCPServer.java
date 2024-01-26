package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String args[])throws Exception
    {
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("Server ready for connection");
        Socket sock = sersock.accept();
        System.out.println("Connection is successful and waiting for chatting");
        InputStream istream = sock.getInputStream();
        BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));
        String fname = fileRead.readLine();
        BufferedReader contentRead =  new BufferedReader(new FileReader(fname));
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream,true);
        String str1;
        while((str1 = contentRead.readLine()) != null)
        {
            pwrite.println(str1);
        }
        sock.close();
        sersock.close();
        pwrite.close();
        fileRead.close();
        contentRead.close();
    }
}
