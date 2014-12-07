/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
