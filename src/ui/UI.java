package ui;

import block.Block;
import block.BlockChain;
import mining.Miner;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UI {
    private final BlockChain blockChain = BlockChain.getInstance();
    ExecutorService executorService= Executors.newFixedThreadPool(100);
    Set<Callable<Block>> miners = new HashSet<>();

    public void showMenu() throws Exception {

        for (int i = 0; i < 5; i++) {
            miners.add(new Miner(blockChain));
            var block = executorService.invokeAny(miners);
            blockChain.addBlockToBlockChain(block);
        }
        executorService.shutdown();
        for (Block block : blockChain.getBlockChainList()) {
            System.out.println(block);
        }
        executorService.shutdown();
    }
}
