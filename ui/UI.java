package ui;

import blockchain.Block;
import blockchain.BlockChain;

public class UI {

    private final BlockChain blockChain = new BlockChain();

    public void showMenu() {

        for (int i = 0; i < 5; i++) {
            blockChain.addBlockToBlockChain(3);
        }
        for (Block block : blockChain.getBlockChain()) {
            System.out.println(block);
        }
    }

}