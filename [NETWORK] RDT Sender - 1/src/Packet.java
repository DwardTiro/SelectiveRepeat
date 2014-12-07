
/**
 *
 * @author Arces
 */
public class Packet {
    private int sequenceNum;
    private byte[] dataBytes;
    
    public Packet(int sequenceNum, byte[] dataBytes){
        this.sequenceNum = sequenceNum;
        this.dataBytes = dataBytes;
    }
    
    public int getSequenceNumber(){
        return sequenceNum;
    }
    
    public byte[] getData(){
        return dataBytes;
    }
}
