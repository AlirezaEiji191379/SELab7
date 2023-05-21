import codeGenerator.Abstractions.ICodeGeneratorOperation;
import org.reflections.Reflections;
import parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Parser parser = new Parser(new Scanner(new File("src/main/resources/code")));
            // start parsing
            parser.startParse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
