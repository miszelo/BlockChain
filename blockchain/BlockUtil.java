package blockchain;

import hashing.HashUtil;

import java.util.Random;

public class BlockUtil {

    public static final String DEFAULT_HASH = "0";

    private static final Random random = new Random();

    public static String generateHash(Block block, int requiredNumberOfZeros) {
        String hash;
        int magicNumber;
        do {
            magicNumber = generateMagicNumber();
            hash = HashUtil.applySha256(block.getID()
                    + String.valueOf(block.getTimestamp())
                    + magicNumber
                    + block.getPrevHash());
        } while (!isHashValid(hash, requiredNumberOfZeros));
        block.setMagicNumber(magicNumber);
        return hash;
    }

    private static boolean isHashValid(String hash, int requiredNumberOfZeros) {
        return hash.startsWith("0".repeat(requiredNumberOfZeros));
    }

    private static int generateMagicNumber() {
        return random.nextInt();
    }

}