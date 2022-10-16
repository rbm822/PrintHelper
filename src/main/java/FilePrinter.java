package src.main.java;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FilePrinter {
    private Desktop desktop;

    public FilePrinter() {
        this.desktop = Desktop.getDesktop();
    }

    public void printFiles(List<File> files) {
        for (File file : files) {
            try {
                desktop.print(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
