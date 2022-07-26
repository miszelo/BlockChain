package blockchain;

import utils.BlockUtil;

import java.util.Date;

public class Block {
    private final int ID;
    private final long timestamp;
    private final String prevHash;
    private int magicNumber;
    private String currentHash;
    private long generatingTime;
    private static int currentID = 1;

    Block(String prevHash) {
        this.ID = currentID++;
        this.timestamp = new Date().getTime();
        this.prevHash = prevHash;
    }

    public static Block createBlock(String prevHash, int requiredNumberOfZeros) {
        Block block = new Block(prevHash);
        block.currentHash = BlockUtil.generateHash(block, requiredNumberOfZeros);
        return block;
    }

    public void setMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public void setGeneratingTime(long generatingTime) {
        this.generatingTime = generatingTime;
    }

    public int getID() {
        return ID;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    @Override
    public String toString() {
        return "Block: \n" +
                "Id: " + ID + "\n" +
                "Timestamp: " + timestamp + "\n" +
                "Magic number: " + magicNumber + "\n" +
                "Hash of the previous block:\n" + prevHash + "\n" +
                "Hash of the block:\n" + currentHash + "\n" +
                "Block was generating for " + generatingTime + " seconds" + "\n";
    }

}
