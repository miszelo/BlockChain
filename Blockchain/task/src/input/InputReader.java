package input;

import java.util.Scanner;

public interface InputReader<T> {

    Scanner scanner = new Scanner(System.in);

    T readInput();
}
