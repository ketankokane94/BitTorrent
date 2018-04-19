
package atktorrent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ketan
 */
public class Sendpiece implements Runnable{
Socket sock;
Master m;
int n ,piece_no;
byte[] mybytearray = new byte[65536];
   public Sendpiece(Master m, Socket sock,int piece_no) {
       this.sock= sock;
       this.piece_no=piece_no;
       this.m=m;
           }

  

    @Override
    public void run() {
            try {
                RandomAccessFile f = new RandomAccessFile("//home//ketan//Desktop//"
                        +"interstellar.mp3","r");
                if(piece_no!=0)
                f.seek((piece_no-1)*65536);
               else
                    f.seek(0);
                try {
                    if(piece_no==m.getNoOfPieces())
                    {
                        f.readFully(mybytearray, 0, m.getLastPiece());
                    }
                    else if(piece_no< m.getNoOfPieces())
                    {
                        f.readFully(mybytearray, 0, mybytearray.length);
                    }
                    else
                    {
                        return;
                    }
                   
                     
                    
                    OutputStream os = sock.getOutputStream();
                    os.write(mybytearray, 0, mybytearray.length);
                    os.flush();
                    System.out.println("data sended");
                    
                    sock.close();
                    f.close();
                 //   m.updatePieces(piece_no);
                }
                catch (IOException ex ) {
                    Logger.getLogger(Sendpiece.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Sendpiece.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Sendpiece.class.getName()).log(Level.SEVERE, null, ex);
    }
            
    }
    }

    

