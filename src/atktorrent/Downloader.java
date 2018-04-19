
package atktorrent;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Downloader implements Runnable{
    Master m;
    

    public Downloader(Master m) {
        this.m=m;
        
       
    }

    @Override
    public void run() {
       
        
       while(!(m.fileisdownloaded()))
       {
            try {
                System.out.println("Downloader started");
                Socket sock = new Socket (m.getIP(),6762);
                if(sock!=null){
                    System.out.println("am in socket was not null");
                DownloaderHandler dh = new DownloaderHandler(m,sock);
                Thread tdh = new Thread(dh);
                tdh.start();}
                
                Thread.sleep(200);
            } 
            catch (IOException | InterruptedException ex) {
                Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
   
   
       
                
        
       
    }

  
    
}
