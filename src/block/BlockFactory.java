package block;

public class BlockFactory {

    public synchronized static Block createBlock(String prevHash, int requiredNumberOfZeros, long minerID) {
        HashInfo hashInfo = HashFactory.generateHash(prevHash, requiredNumberOfZeros, minerID);
        return new Block(hashInfo);
    }
}
