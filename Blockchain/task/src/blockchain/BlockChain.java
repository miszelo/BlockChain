package blockchain;

import java.util.LinkedList;
import java.util.List;

public class BlockChain {
    private final List<Block> blockChain = new LinkedList<>();

    public void addBlock() {
        blockChain.add(new Block(getPrevHash()));
    }

    private String getPrevHash() {
        if (blockChain.size() == 0) {
            return "0";
        }
        return blockChain.get(blockChain.size() - 1).getCurrentHash();
    }

    public List<Block> getBlockChain() {
        return blockChain;
    }

}
