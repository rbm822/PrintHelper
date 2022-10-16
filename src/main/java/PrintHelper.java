package src.main.java.main;

import src.main.java.printer.FilePrinter;
import src.main.java.utils.FileExtensionChanger;
import src.main.java.utils.FileLoader;

import java.io.File;
import java.util.List;

public class PrintHelper {
    public static void main(String[] args) {
        String directory = args[0];
        String desiredFileType = args[1];
        FilePrinter filePrinter = new FilePrinter();

        FileLoader fileLoader = new FileLoader(directory, desiredFileType);
        List<File> fileList = fileLoader.getFilesFromDirectory();
        FileExtensionChanger fileExtensionChanger = new FileExtensionChanger(fileList);
        fileExtensionChanger.changeFileExtension(".java", ".txt");
//        filePrinter.printFiles(fileList);
    }
}
