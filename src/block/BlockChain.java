package block;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter(AccessLevel.PACKAGE)
public class BlockChain {

    private static BlockChain INSTANCE;

    @Setter(AccessLevel.NONE)
    private final List<Block> blockChain = new LinkedList<>();

    private int requiredNumberOfZeros = 0;

    private BlockChain() {}

    public static BlockChain getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BlockChain();
        }
        return INSTANCE;
    }

    public void addBlockToBlockChain(Block block) {
        blockChain.add(block);
        BlockUtil.checkWhetherIncrementNumberOfZeros(block.hashInfo.getGeneratingTime(), this);
    }
}
