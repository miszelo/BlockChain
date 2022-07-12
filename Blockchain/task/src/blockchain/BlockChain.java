package blockchain;

import printing.Printer;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {
    private final List<Block> blockChain = new LinkedList<>();

    public void addBlock(Block block) {
        blockChain.add(block);
    }

    public String getPrevHash() {
        return blockChain.get(blockChain.size() - 1).getCurrentHash();
    }

    public void printBlockChain() {
        for (Block block : blockChain) {
            Printer.printInfoAboutBlock(block.getID(), block.getTimestamp(), block.getPrevHash(), block.getCurrentHash());
        }
    }
}
