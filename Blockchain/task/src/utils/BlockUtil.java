package utils;

import blockchain.Block;

import java.util.Date;
import java.util.Random;

public class BlockUtil {
    private static final Random random = new Random();

    public static String generateHash(Block block, int requiredNumberOfZeros) {
        String hash;
        int magicNumber;
        do {
            magicNumber = generateMagicNumber();
            hash = StringUtil.applySha256(block.getID()
                    + String.valueOf(block.getTimestamp())
                    + magicNumber
                    + block.getPrevHash());
        } while (!isHashValid(hash, requiredNumberOfZeros));
        block.setMagicNumber(magicNumber);
        block.setGeneratingTime((new Date().getTime() - block.getTimestamp())/1000);
        return hash;
    }

    private static boolean isHashValid(String hash, int requiredNumberOfZeros) {
        return hash.startsWith("0".repeat(requiredNumberOfZeros));
    }

     public static int generateMagicNumber() {
        return random.nextInt();
    }

}
