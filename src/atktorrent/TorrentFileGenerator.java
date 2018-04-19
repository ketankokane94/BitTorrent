
package atktorrent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author kimaya
 */
public class TorrentFileGenerator {
    File fp1;
    FileInputStream fis;
    JSONObject tor;
    int pieceSize=65536;
    int last;
    int no;
    torObject crcefile = new torObject();
    String destination_directory;
    
    public TorrentFileGenerator(String source_directory,String name,String destination_directory) throws NoSuchAlgorithmException {
        
            String destination_file;
        try {
            fp1=new File(source_directory);
            fis = new FileInputStream(fp1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TorrentFileGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        crcefile.setFileSize(fp1.length());
        crcefile.setFileName(name);
        crcefile.setSizeOfPiece(pieceSize);
        destination_file = name.replace(".","")+".crce";
        this.destination_directory=destination_directory+"/"+destination_file;
        
        System.out.println(destination_directory);
        no=  (int)(fp1.length()/pieceSize);
        last= (int) (fp1.length()%pieceSize);
        if(last!=0)
        {
            no+=1;
            
        }
        
        crcefile.setNoOfPieces(no);
        crcefile.setLastPiece(last);
        crcefile.setFileHash(findHash(crcefile.getFileName()));
       
        
       String [] ketan = new String [crcefile.getNoOfPieces()];
       
           byte[] dataBytes = new byte[crcefile.getSizeOfPiece()];
 
        int nread = 0; 
        int i=0;
       
        
          
        try {
            while ((nread = fis.read(dataBytes)) != -1) {
                ketan[i]=findHash(Arrays.toString(dataBytes));
                i++;
              
                
            }
             
        } catch (IOException ex) {
            Logger.getLogger(TorrentFileGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       crcefile.setPieceHash(ketan);
       
       generateFile();
    }

   
    
    
    private String findHash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(input.getBytes());
        byte [] output =md.digest();
        return bytesToHex(output);
    }
    
    public String bytesToHex(byte[] b) {
      char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
      StringBuffer buf = new StringBuffer();
      for (int j=0; j<b.length; j++) {
         buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
         buf.append(hexDigit[b[j] & 0x0f]);
      }
      return buf.toString();
   }

    private void generateFile() {
        
        try {
            tor =new JSONObject();
            tor.put("FILENAME",crcefile.getFileName());
            tor.put("FILEHASH",crcefile.getFileHash());
            tor.put("FILESIZE",crcefile.getFileSize());
            tor.put("NO_OF_PIECES",crcefile.getNoOfPieces());
            tor.put("SIZE_OF_PIECE",crcefile.getSizeOfPiece());
            tor.put("SIZE_OF_LAST_PIECE",crcefile.getLastPiece());
            tor.put("CREATOR",crcefile.getCreator());
            tor.put("TRACKER_URL",crcefile.getUrlTracker());
            tor.put("PIECES",crcefile.getPieceHash());
        } catch (JSONException ex) {
            Logger.getLogger(TorrentFileGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
             
            try (PrintWriter writer = new PrintWriter(destination_directory, "UTF-8")) {
                writer.println(tor.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       
    }

 
    
   
}
