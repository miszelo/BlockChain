package mining;

import block.Block;
import block.BlockChain2;
import block.BlockFactory;
import block.BlockUtil2;

import java.util.concurrent.Callable;

public class Miner2 implements Callable<Block> {

    BlockChain2 blockChain2;

    public Miner2(BlockChain2 blockChain2) {
        this.blockChain2 = blockChain2;
    }

    @Override
    public Block call() {
        return BlockFactory.createBlock(BlockUtil2.getPrevHash(), blockChain2.getRequiredNumberOfZeros(), Thread.currentThread().getId());
    }
}