package blockchain;


public class Main {
    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();
        blockChain.addBlock(new Block("0"));
        for (int i = 1; i < 5; i++) {
            blockChain.addBlock(new Block(blockChain.getPrevHash()));
        }
        blockChain.printBlockChain();
    }
}
