package printing;

import blockchain.Block;

public class Printer {
    public static String printInfoAboutBlock(Block block) {
        return block.toString();
    }
}
