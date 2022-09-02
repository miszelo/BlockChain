package block;

import hashing.HashUtil;

import java.util.Date;

class HashFactory {

    public static HashInfo generateHash(String prevHash, int requiredNumberOfZeros, int minerID) {
        int ID = ++BlockUtil.currentID;
        long timestamp = new Date().getTime();
        String hash;
        int magicNumber;
        long generatingTime;

        do {
            magicNumber = BlockUtil.generateMagicNumber();
            hash = HashUtil.applySha256(ID
                    + String.valueOf(timestamp)
                    + magicNumber
                    + prevHash);
        } while (!BlockUtil.isHashValid(hash, requiredNumberOfZeros));

        generatingTime = (new Date().getTime() - timestamp) / 1000;

        return new HashInfo(ID, timestamp, prevHash, magicNumber, hash, generatingTime, requiredNumberOfZeros, minerID);
    }

}
