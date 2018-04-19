
package atktorrent;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kimaya
 */
public class Getpiece implements Runnable {
    Master m ;
    Socket sock;
    int randomInt;
    byte[] data = new byte[65536];
    InputStream is;
    DataInputStream dis;

    public Getpiece(Master m, Socket sock, int randomInt) {
       this.m=m;
       this.sock=sock;
       this.randomInt=randomInt;
    }
    

    @Override
    public void run() {
       
                 
        try {
            is = sock.getInputStream();
            dis = new DataInputStream(is);
            
                    try (RandomAccessFile f = new RandomAccessFile("/Users/kimayadesai/Desktop"
                            + "pineapple.jpg","rw")) {
                       
                    if(randomInt==0)
                       f.seek(0);
                      else
                        f.seek((randomInt-1)*65536);
                    if(randomInt==m.getNoOfPieces())
                    {
                        dis.readFully(data, 0, m.getLastPiece());
                    }
                    else
                    {
                        dis.readFully(data, 0, m.getSizeOfPiece());
                    }
                        
                        
                    
                        
                        
                        f.write(data, 0, data.length);
                        f.close();
                        System.out.println("piece "+randomInt +"downloaded");
                        m.updatePieces(randomInt);
                    }
        }
        catch (IOException ex) {
            Logger.getLogger(Getpiece.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}