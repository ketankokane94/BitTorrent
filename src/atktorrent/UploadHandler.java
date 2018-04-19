
package atktorrent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ketan
 */
public class UploadHandler implements Runnable {
    
    Master m ;
    Socket sock;
    InputStream is;
    OutputStream os;
    DataOutputStream dos;
    DataInputStream dis;
    
   public UploadHandler(Master m, Socket sock) {
        this.m=m;
        this.sock = sock;
        
    }
    
    
    public void run()
    {
        try {
            System.out.println("uploadHandler started");
            byte[]message =new byte[100];
            is= sock.getInputStream();
            dis = new DataInputStream(is);
            
            int piece = dis.readInt();
            System.out.println("requested piece is "+piece);
            os = sock.getOutputStream();
            dos= new DataOutputStream(os);
            dos.write("ok".getBytes());
          
            System.out.println("sendpiece started");
            Sendpiece sp = new Sendpiece(m , sock , piece);
            Thread tsp = new Thread(sp);
            tsp.start();
            
            
            
        } 
        catch (IOException ex) {
            Logger.getLogger(UploadHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
