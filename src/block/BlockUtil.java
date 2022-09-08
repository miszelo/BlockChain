package block;

import java.util.Random;

final public class BlockUtil {

    public static final String DEFAULT_HASH = "0";

    public static final long MAX_GENERATING_TIME = 60;

    public static final long MIN_GENERATING_TIME = 15;

    private static final Random random = new Random();

    static boolean isHashValid(String hash, int requiredNumberOfZeros) {
        return hash.startsWith("0".repeat(requiredNumberOfZeros));
    }

    static int generateMagicNumber() {
        return random.nextInt();
    }

    static String getIncreaseDecreaseMessage(long generatingTime, int numberOfZeros) {
        if (generatingTime < MIN_GENERATING_TIME) {
            return "N was increased to " + (numberOfZeros + 1);
        } else if (generatingTime > MAX_GENERATING_TIME) {
            return "N was decreased to " + (numberOfZeros - 1);
        }
        return "N stays the same";
    }

    static void checkWhetherIncrementNumberOfZeros(long generatingTime, BlockChain blockChain) {
        if (generatingTime < MIN_GENERATING_TIME) {
            blockChain.setRequiredNumberOfZeros(blockChain.getRequiredNumberOfZeros() + 1);
        } else if (generatingTime > MAX_GENERATING_TIME) {
            blockChain.setRequiredNumberOfZeros(blockChain.getRequiredNumberOfZeros() - 1);
        }
    }

    public static String getPrevHash() {
        var blockChain = BlockChain.getInstance().getBlockChain();
        return blockChain.isEmpty() ? DEFAULT_HASH : blockChain.get(blockChain.size() - 1).hashInfo.getCurrentHash();
    }


}