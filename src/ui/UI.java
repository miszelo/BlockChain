package ui;

import block.Block;
import block.BlockChain;

public class UI {

    private final BlockChain blockChain = new BlockChain();

    public void showMenu() {

        for (int i = 0; i < 5; i++) {
            blockChain.addBlockToBlockChain(2);
        }

        for (Block block : blockChain.getBlockChain()) {
            System.out.println(block);
        }
    }

}