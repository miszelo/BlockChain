package blockchain;

import java.util.Date;

public class Block {
    private final int ID;
    private final long timestamp;
    private final String prevHash;
    private final String currentHash;
    private static int currentID = 1;

    public Block(String prevHash) {
        this.ID = currentID++;
        this.timestamp = new Date().getTime();
        this.currentHash = calculateHash();
        this.prevHash = prevHash;
    }

    private String calculateHash() {
        String hash = ID + String.valueOf(timestamp) + prevHash;
        return StringUtil.applySha256(hash);
    }

    public int getID() {
        return ID;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public String getPrevHash() {
        return prevHash;
    }
}
