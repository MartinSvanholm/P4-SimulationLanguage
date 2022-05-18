import java.util.ArrayList;



public class ErrorHandler {
    public ArrayList<Error> Errors = new ArrayList<>();
    public Boolean HasErrors = false;

    public void PrintErrors() {
        for(Error error : Errors) {
            System.out.println(Main.ANSI_RED + "Error: " + error.Message + ", at line " + error.Line + Main.ANSI_RESET);
        }
    }
}
