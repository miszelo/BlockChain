package mining;

import block.Block;
import block.BlockChain;
import block.BlockFactory;
import block.BlockUtil;

import java.util.concurrent.Callable;

public class Miner implements Callable<Block> {

    BlockChain blockChain;

    public Miner(BlockChain blockChain) {
        this.blockChain = blockChain;
    }

    @Override
    public Block call() {
        return BlockFactory.createBlock(BlockUtil.getPrevHash(), blockChain.getRequiredNumberOfZeros(), Thread.currentThread().getId());
    }
}