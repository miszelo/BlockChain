package block;

import java.util.LinkedList;
import java.util.List;

public class BlockChain2 {
    private static BlockChain2 blockChain2;
    private final List<Block> blockChainList = new LinkedList<>();
    private int requiredNumberOfZeros = 0;

    private BlockChain2() {}

    public static BlockChain2 getInstance() {
        if (blockChain2 == null) {
            blockChain2 = new BlockChain2();
        }
        return blockChain2;
    }

    public void addBlockToBlockChain(Block block) {
        blockChainList.add(block);
        BlockUtil2.checkWhetherIncrementNumberOfZeros(block.hashInfo.getGeneratingTime(), this);
    }

    public List<Block> getBlockChainList() {
        return blockChainList;
    }

    void setRequiredNumberOfZeros(int newRequiredNumberOfZeros) {
        requiredNumberOfZeros = newRequiredNumberOfZeros;
    }

    public int getRequiredNumberOfZeros() {
        return requiredNumberOfZeros;
    }
}
