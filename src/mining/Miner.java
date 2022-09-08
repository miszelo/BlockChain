package mining;

import block.BlockChain;

public class Miner implements Runnable {

    BlockChain blockChain;

    public Miner(BlockChain blockChain) {
        this.blockChain = blockChain;
    }

    @Override
    public void run() {

    }
}
