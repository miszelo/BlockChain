package ui;

import blockchain.Block;
import blockchain.BlockChain;
import input.IntegerReader;
import input.InputReader;
import printing.Printer;

public class UI {

    private final BlockChain blockChain = new BlockChain();
    private final Printer printer = new Printer();
    private final InputReader<Integer> integerReader = new IntegerReader();

    public void showMenu() {
        printer.howManyZerosTheHashMustStartWithMessage();
        var numberOfZeros = integerReader.readInput();

        for (int i = 0; i < 2; i++) {
            blockChain.addBlock(numberOfZeros);
        }
        for (Block block : blockChain.getBlockChain()) {
            System.out.println(block.toString());
        }
    }

}
