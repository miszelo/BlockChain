package block;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {
    private static BlockChain blockChain;
    private final List<Block> blockChainList = new LinkedList<>();
    private int requiredNumberOfZeros = 0;

    private BlockChain() {}

    public static BlockChain getInstance() {
        if (blockChain == null) {
            blockChain = new BlockChain();
        }
        return blockChain;
    }

    public void addBlockToBlockChain(Block block) {
        blockChainList.add(block);
        BlockUtil.checkWhetherIncrementNumberOfZeros(block.hashInfo.getGeneratingTime(), this);
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
