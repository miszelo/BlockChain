package blockchain;

public class Main {
    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();
        for (int i = 0; i < 5; i++) {
            blockChain.addBlock();
        }
        for (Block block : blockChain.getBlockChain()) {
            System.out.println(block.toString());
        }
    }
}
