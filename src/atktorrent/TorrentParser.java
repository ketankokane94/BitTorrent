
package atktorrent;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

import org.json.simple.parser.*;



/**
 *
 * @author ketan
 */
public class TorrentParser {
    
    Master m;

    public TorrentParser(String Sourcefile) {
         try {
            m= new Master();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader (Sourcefile));
            org.json.simple.JSONObject json = (org.json.simple.JSONObject) obj;
            m.setFileName((String) json.get("FILENAME"));  
            m.setFileHash((String) json.get("FILEHASH"));
            m.setFileSize((long) json.get("FILESIZE"));
            m.setNoOfPieces((int)(long)json.get("NO_OF_PIECES"));
            m.setPieceHash((String [])json.get("PIECEHASH"));
            m.setCreator(((String)json.get("CREATOR")));
            m.setUrlTracker((String)json.get("TRACKER_URL"));
            m.setLastPiece((int)(long)json.get("SIZE_OF_LAST_PIECE"));
            m.setSizeOfPiece((int)(long)json.get("SIZE_OF_PIECE"));
            m.setIP("127.0.0.1");
            System.out.println(json.toJSONString());
            m.Start();
            //Master master = new Master();
        
        } catch (IOException | ParseException ex) {
            Logger.getLogger(TorrentParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
