package ui;

import block.BlockChain;
import block.BlockFactory;
import block.HashInfo;
import mining.Miner;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UI {
    private final BlockChain blockChain = BlockChain.getInstance();
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final Set<Callable<HashInfo>> miners = new HashSet<>();

    public void showMenu() throws Exception {

        for (int i = 0; i < 1000; i++) {
            miners.add(new Miner(blockChain));
        }

        for (int i = 0; i < 5; i++) {
            var hash = executorService.invokeAny(miners);
            var block = BlockFactory.createBlock(hash, i + 1);
            blockChain.addBlockToBlockChain(block);
        }
        executorService.shutdown();

        blockChain.getBlockChain()
                .forEach(System.out::println);
    }
}
