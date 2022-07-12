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
        this.prevHash = prevHash;
        this.currentHash = generateHash();
    }

    private String generateHash() {
        return StringUtil.applySha256(ID + String.valueOf(timestamp) + prevHash);
    }

    @Override
    public String toString() {
        return "Block: \n" +
                "ID: " + ID + "\n" +
                "Timestamp: " + timestamp + "\n" +
                "Hash of the previous block:\n" + prevHash + "\n" +
                "Hash of the block:\n" + currentHash + "\n";
    }

    public String getCurrentHash() {
        return currentHash;
    }
}
