package IO.input;

public class IntegerInputValidator implements InputValidator {

    @Override
    public boolean isValid(String input) {
        return isInputInteger(input);
    }

    private boolean isInputInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("It`s not an integer!");
        }
    }

}