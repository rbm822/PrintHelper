package src.main.java;

import java.io.File;
import java.util.List;

public class PrintHelper {
    public static void main(String[] args) {
        // TODO need input validation
        String directory = args[0];
        String desiredFileType = args[1];
        FilePrinter filePrinter = new FilePrinter();
        FileLoader fileLoader = new FileLoader(directory, desiredFileType);
        List<File> filesToPrint = fileLoader.getFiles();
        filePrinter.printFiles(filesToPrint);
    }
}
