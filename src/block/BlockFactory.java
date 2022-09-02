package block;

public class BlockFactory {

    public static Block createBlock(String prevHash, int requiredNumberOfZeros, int minerID) {
        HashInfo hashInfo = HashFactory.generateHash(prevHash, requiredNumberOfZeros, minerID);
        return new Block(hashInfo);
    }
}
