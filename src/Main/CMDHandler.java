package Main;

import ASTNodes.ProgramNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CMDHandler {
    public void RunEXE() {
        String[] cmd = {"Output/Simulation.exe"};

        try {
            Process process = Runtime.getRuntime().exec(cmd);
            printResults(process);

        } catch (IOException e) {
            System.out.println("An unexpected error occurred!");
            System.out.println(e.getMessage());
        }
    }

    public void dotnetCompilse(){
        String[] cmd2 = {"dotnet","publish","-p:PublishSingleFile=true","-p:RuntimeIdentifier=win-x64","-p:AssemblyName=Simulation","-o","Output"};

        try {
            Process process2 = Runtime.getRuntime().exec(cmd2);
            printResults(process2);

        } catch (IOException e) {
            System.out.println("An unexpected error occurred!");
            System.out.println(e.getMessage());
        }
    }

    public static void printResults(Process process) throws IOException {
        System.out.println(process.pid());

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
