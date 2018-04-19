
package atktorrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kimaya
 */
public class Uploader implements Runnable{
    Master m;
    ServerSocket servsock = null;
    Socket sock = null;

   public  Uploader(Master aThis) {
       this.m=aThis;
    }

    @Override
    public void run() {
        try {
             System.out.println("uploader started");
            servsock = new ServerSocket(6762);
            while(true){
                 System.out.println("Waitng for connection");
                sock = servsock.accept();
                UploadHandler uh = new UploadHandler(m,sock);
                Thread tuh = new Thread(uh);
                tuh.start();
                Thread.sleep(200);
            }
            
    
            
      
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Uploader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
