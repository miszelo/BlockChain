package block;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {

    private final List<Block> blockChain = new LinkedList<>();
    private int requiredNumberOfZeros = 0;

    public void addBlockToBlockChain(long minerID) {
        Block block;
        if (blockChain.isEmpty()) {
            block = BlockFactory.createBlock(
                    BlockUtil.DEFAULT_HASH,
                    requiredNumberOfZeros,
                    minerID);
        } else {
            block = BlockFactory.createBlock(
                    blockChain.get(blockChain.size() - 1).hashInfo.getCurrentHash(),
                    requiredNumberOfZeros,
                    minerID);
        }
        BlockUtil.checkWhetherIncrementNumberOfZeros(block.hashInfo.getGeneratingTime(), this);
        blockChain.add(block);
    }

    public List<Block> getBlockChain() {
        return blockChain;
    }

    void setRequiredNumberOfZeros(int newRequiredNumberOfZeros) {
        requiredNumberOfZeros = newRequiredNumberOfZeros;
    }

    int getRequiredNumberOfZeros() {
        return requiredNumberOfZeros;
    }
}
