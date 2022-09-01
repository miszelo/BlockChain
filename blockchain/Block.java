package blockchain;

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

    static Block createBlock(String prevHash, int requiredNumberOfZeros) {
        Block block = new Block(prevHash);
        block.currentHash = BlockUtil.generateHash(block, requiredNumberOfZeros);
        block.generatingTime = (new Date().getTime() - block.timestamp)/1000;
        return block;
    }

    void setMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    int getID() {
        return ID;
    }

    long getTimestamp() {
        return timestamp;
    }

    String getPrevHash() {
        return prevHash;
    }

    String getCurrentHash() {
        return currentHash;
    }

    @Override
    public String toString() {
        return "Block: \n" +
                "Created by miner # " + "\n" +
                "Id: " + ID + "\n" +
                "Timestamp: " + timestamp + "\n" +
                "Magic number: " + magicNumber + "\n" +
                "Hash of the previous block:\n" + prevHash + "\n" +
                "Hash of the block:\n" + currentHash + "\n" +
                "Block was generating for " + generatingTime + " seconds" + "\n";
    }
}
