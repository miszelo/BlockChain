package block;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {

    private final List<Block> blockChain = new LinkedList<>();
    private int requiredNumberOfZeros = 0;

    public void addBlockToBlockChain(int minerID) {
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
        checkWhetherIncrementNumberOfZeros(block.hashInfo.getGeneratingTime());
        blockChain.add(block);
    }

    private void checkWhetherIncrementNumberOfZeros(long generatingTime) {
        if (generatingTime < BlockUtil.MIN_GENERATING_TIME) {
            requiredNumberOfZeros++;
        } else if (generatingTime > BlockUtil.MAX_GENERATING_TIME) {
            requiredNumberOfZeros--;
        }
    }

    public List<Block> getBlockChain() {
        return blockChain;
    }

    public void setRequiredNumberOfZeros(int newRequiredNumberOfZeros) {
        requiredNumberOfZeros = newRequiredNumberOfZeros;
    }

    public int getRequiredNumberOfZeros() {
        return requiredNumberOfZeros;
    }
}
