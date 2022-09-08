package ui;

import block.Block;
import block.BlockChain2;
import mining.Miner2;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UI2 {
    private final BlockChain2 blockChain2 = BlockChain2.getInstance();
    ExecutorService executorService;


    public void showMenu() throws Exception {

        for (int i = 0; i < 5; i++) {
            executorService = Executors.newFixedThreadPool(20);
            Set<Callable<Block>> miners = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                miners.add(new Miner2(blockChain2));
            }
            var block = executorService.invokeAny(miners);
            blockChain2.addBlockToBlockChain(block);
            executorService.shutdown();
        }

        for (Block block : blockChain2.getBlockChainList()) {
            System.out.println(block);
        }
        executorService.shutdown();
    }
}
