
package atktorrent;

import java.io.RandomAccessFile;

/**
 *
 * @author ketan
 */
public class Master {

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public int getNoOfPieces() {
        return noOfPieces;
    }

    public void setNoOfPieces(int noOfPieces) {
        this.noOfPieces = noOfPieces;
    }

    public int getLastPiece() {
        return lastPiece;
    }

    public void setLastPiece(int lastPiece) {
        this.lastPiece = lastPiece;
    }

    public int getSizeOfPiece() {
        return sizeOfPiece;
    }

    public void setSizeOfPiece(int sizeOfPiece) {
        this.sizeOfPiece = sizeOfPiece;
    }

    public String[] getPieceHash() {
        return pieceHash;
    }

    public void setPieceHash(String[] pieceHash) {
        this.pieceHash = pieceHash;
    }

    public String getUrlTracker() {
        return UrlTracker;
    }

    public void setUrlTracker(String UrlTracker) {
        this.UrlTracker = UrlTracker;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String Creator) {
        this.Creator = Creator;
    }
    private String fileName;
    private String fileHash;
    private long fileSize;
    private int noOfPieces;
    private int lastPiece;
    private int sizeOfPiece;
    private String[] pieceHash;
    private String UrlTracker;
    private String Creator;
    RandomAccessFile file ;
    int[] requiredpieces;
    int downloadedpieces[];
     int ipCounter;
    String []IP=new String[5];
    
    public String[] getIPs() {
        return IP;
    }

    public void setIP(String ip) {
       // this.IP = IP;
        IP[0]="127.0.0.1";
        IP[1]="127.0.0.1";IP[2]="127.0.0.1";
        IP[3]="127.0.0.1";IP[4]="127.0.0.1";
    }
   
        public void Start()
        {
            System.out.println("master has  started");
             setupPieces();
            Uploader up= new Uploader(this);
            Thread tup = new Thread(up);
            Downloader dw = new Downloader(this);
            Thread tdw = new Thread(dw);
            
           
            
                tup.start();
                tdw.start();
                
                
        }

    private void setupPieces() {//initialise all the arrays required.
        requiredpieces= new int[noOfPieces];
        downloadedpieces= new int[noOfPieces];
       for(int i = 0;i<noOfPieces;i++)
       {
           requiredpieces[i]=0;//0 means not available n is required // 1 means downloaded
           downloadedpieces[i]=0;//-1 means not available //0 means downloaded
       }
    }
    
    public boolean checkNeeded(int n)
    {
        boolean flag ;
        if(requiredpieces[n]==0)
        flag=true;
        else
            flag = false;
        return flag;
    }
     
    public boolean checkAvailable(int n )
     {
        boolean flag ;
        if(downloadedpieces[n]==0)
        flag=true;
        else
            flag = false;
        return flag; 
     }
    public void updatePieces(int n)
    {
        requiredpieces[n]=1;
        downloadedpieces[n]=0;
    }
    
    public String getIP()
    {
       if(ipCounter>4) 
          ipCounter=0;
       return IP[ipCounter];
    }
    public int getPiece()
    {
        int randomInt=0;
      for(int i =0;i<noOfPieces;i++)
      {
         if( checkNeeded(i))
         {
             randomInt=i;
         }
      }
        return randomInt;
    }

    public boolean fileisdownloaded() {
        boolean send= false;
        for(int i =0;i< noOfPieces;i++)
        {if(requiredpieces[i]==1){
            send = true;
            continue;}
        else
            {send = false;
            break;
                    }
            
        }
        return send;
    }
}
