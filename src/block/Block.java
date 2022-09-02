package block;

public class Block {

    HashInfo hashInfo;

    Block(HashInfo blockInfo) {
        this.hashInfo = blockInfo;
    }

    @Override
    public String toString() {
        return "Block: \n" +
                "Created by miner # " + hashInfo.getMinerID() + "\n" +
                "Id: " + hashInfo.getID() + "\n" +
                "Timestamp: " + hashInfo.getTimestamp() + "\n" +
                "Magic number: " + hashInfo.getMagicNumber() + "\n" +
                "Hash of the previous block:\n" + hashInfo.getPrevHash() + "\n" +
                "Hash of the block:\n" + hashInfo.getCurrentHash() + "\n" +
                "Block was generating for " + hashInfo.getGeneratingTime() + " seconds" + "\n" +
                hashInfo.getIncreaseDecreaseMessage() + "\n";
    }
}
