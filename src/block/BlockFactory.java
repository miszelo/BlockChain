package block;

public class BlockFactory {

    public static Block createBlock(HashInfo hashInfo, int blockID) {
        return new Block(hashInfo, blockID);
    }
}
