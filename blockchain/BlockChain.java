package blockchain;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {

    private final List<Block> blockChain = new LinkedList<>();

    public void addBlockToBlockChain(int requiredNumberOfZeros) {
        if (blockChain.size() == 0) {
            blockChain.add(Block.createBlock(BlockUtil.DEFAULT_HASH, requiredNumberOfZeros));
        } else {
            blockChain.add(Block.createBlock(blockChain.get(blockChain.size() -1).getCurrentHash(), requiredNumberOfZeros));
        }
    }

    public List<Block> getBlockChain() {
        return blockChain;
    }

}
