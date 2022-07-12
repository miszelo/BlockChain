package printing;

public class Printer {
    public static void printInfoAboutBlock(int ID, long timestamp, String prevHash, String currentHash) {
        System.out.println("Block:");
        System.out.println("Id: " + ID);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Hash of the previous block:");
        System.out.println(prevHash);
        System.out.println("Hash of the block:");
        System.out.println(currentHash);
        System.out.println();
    }
}
