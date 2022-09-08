package block;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
public class HashInfo {

    private final long timestamp;
    private final String prevHash;
    private final int magicNumber;
    private final String currentHash;
    private final long generatingTime;
    private final long minerID;
    private final String increaseDecreaseMessage;


    HashInfo(long timestamp, String prevHash, int magicNumber, String currentHash, long generatingTime, int numberOfZeros, long minerID) {
        this.timestamp = timestamp;
        this.prevHash = prevHash;
        this.magicNumber = magicNumber;
        this.currentHash = currentHash;
        this.generatingTime = generatingTime;
        this.minerID = minerID;
        increaseDecreaseMessage = BlockUtil.getIncreaseDecreaseMessage(generatingTime, numberOfZeros);
    }
}
