package input;

public class IntegerReader implements InputReader<Integer> {

    private final InputValidator integerInputValidator = new IntegerInputValidator();

    @Override
    public Integer readInput() {
        String input = scanner.nextLine();
        if (integerInputValidator.isValid(input)) {
            return Integer.parseInt(input);
        }
        return null;
    }
}
