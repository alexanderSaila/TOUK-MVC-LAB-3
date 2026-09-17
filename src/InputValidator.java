public class InputValidator {

    Controller controller;

    public InputValidator(Controller controller){
        this.controller = controller;
    }

    public boolean checkValidStringInput(String input){
        return input.matches("[a-zA-Z ]*");
    }

    public boolean checkValidKey(String input){
        try {
            int validKey = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Key");
            return false;
        }
        return true;
    }
}
