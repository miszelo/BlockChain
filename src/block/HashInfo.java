package block;

class HashInfo {

    private final int ID;
    private final long timestamp;
    private final String prevHash;
    private final int magicNumber;
    private final String currentHash;
    private final long generatingTime;
    private final int minerID;
    private final String increaseDecreaseMessage;

    HashInfo(int ID, long timestamp, String prevHash, int magicNumber, String currentHash, long generatingTime, int numberOfZeros , int minerID) {
        this.ID = ID;
        this.timestamp = timestamp;
        this.prevHash = prevHash;
        this.magicNumber = magicNumber;
        this.currentHash = currentHash;
        this.generatingTime = generatingTime;
        this.minerID = minerID;
        increaseDecreaseMessage = BlockUtil.getIncreaseDecreaseMessage(generatingTime, numberOfZeros);
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

    int getMagicNumber() {
        return magicNumber;
    }

    String getCurrentHash() {
        return currentHash;
    }

    long getGeneratingTime() {
        return generatingTime;
    }

    int getMinerID() {
        return minerID;
    }

    String getIncreaseDecreaseMessage() {
        return increaseDecreaseMessage;
    }
}
