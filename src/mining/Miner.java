package mining;

import block.BlockChain;
import block.BlockUtil;
import block.HashFactory;
import block.HashInfo;

import java.util.concurrent.Callable;

public class Miner implements Callable<HashInfo> {

    BlockChain blockChain;

    public Miner(BlockChain blockChain) {
        this.blockChain = blockChain;
    }

    @Override
    public HashInfo call() {
        return HashFactory.generateHash(BlockUtil.getPrevHash(), blockChain.getRequiredNumberOfZeros(), Thread.currentThread().getId());
    }
}