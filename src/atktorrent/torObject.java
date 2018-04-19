
package atktorrent;

/**
 *
 * @author ketan
 */
public class torObject {
    private String fileName;
    private String fileHash;
    private long fileSize;
    private int noOfPieces;
    private int lastPiece;
    private int sizeOfPiece;
    private String[] pieceHash;
    private String UrlTracker;
    private String Creator;

    public int getLastPiece() {
        return lastPiece;
    }

    public void setLastPiece(int lastPiece) {
        this.lastPiece = lastPiece;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileHash
     */
    public String getFileHash() {
        return fileHash;
    }

    /**
     * @param fileHash the fileHash to set
     */
    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    /**
     * @return the fileSize
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return the noOfPieces
     */
    public int getNoOfPieces() {
        return noOfPieces;
    }

    /**
     * @param noOfPieces the noOfPieces to set
     */
    public void setNoOfPieces(int noOfPieces) {
        this.noOfPieces = noOfPieces;
    }

    /**
     * @return the sizeOfPiece
     */
    public int getSizeOfPiece() {
        return sizeOfPiece;
    }

    /**
     * @param sizeOfPiece the sizeOfPiece to set
     */
    public void setSizeOfPiece(int sizeOfPiece) {
        this.sizeOfPiece = sizeOfPiece;
    }

    /**
     * @return the pieceHash
     */
    public String[] getPieceHash() {
        return pieceHash;
    }

    /**
     * @param pieceHash the pieceHash to set
     */
    public void setPieceHash(String[] pieceHash) {
        this.pieceHash = pieceHash;
    }

    /**
     * @return the UrlTrackert
     */
    public String getUrlTracker() {
        return UrlTracker;
    }

    /**
     * @param UrlTrackert the UrlTrackert to set
     */
    public void setUrlTracker(String UrlTrackert) {
        this.UrlTracker = UrlTrackert;
    }

    /**
     * @return the Creator
     */
    public String getCreator() {
        return Creator;
    }

    /**
     * @param Creator the Creator to set
     */
    public void setCreator(String Creator) {
        this.Creator = Creator;
    }
    
    
}
