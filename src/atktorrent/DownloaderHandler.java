
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
public class DownloaderHandler implements Runnable{
        
    Master m ;
    Socket sock;
    InputStream is;
    OutputStream os;
     int randomInt;
     DataOutputStream dos;
    DataInputStream dis;
                
    public DownloaderHandler(Master m, Socket sock) {
        this.m = m;
        this.sock=sock;
       
    }

    @Override
    public void run() {
        try {
            System.out.println("downloadHandler started");
            byte[]message =new byte[1000];
            os= sock.getOutputStream();
            dos= new DataOutputStream(os);
           
              randomInt=m.getPiece();
             dos.writeInt(randomInt);
       
            
           
                is=sock.getInputStream();
                dis = new DataInputStream(is);
                dis.read(message);
           
          
            Getpiece sp = new Getpiece(m , sock,randomInt);
            Thread tgp = new Thread(sp);
            tgp.start();
        } 
        catch (IOException ex) {
            Logger.getLogger(DownloaderHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
    }
    
}
