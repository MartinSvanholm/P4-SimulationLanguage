package Main;

import java.util.ArrayList;

import static Main.Main.ANSI_RED;
import static Main.Main.ANSI_RESET;

public class ErrorHandler {
    public ArrayList<Error> Errors = new ArrayList<>();
    public Boolean HasErrors = false;

    public void PrintErrors() {
        for(Error error : Errors) {
            System.out.println(ANSI_RED + "Error: " + error.Message + ", at line " + error.Line + ANSI_RESET);
        }
    }
}
