package src.main.java.utils;

import java.io.File;
import java.util.List;

public class FileExtensionChanger {
    private List<File> files;

    public FileExtensionChanger(List<File> files) {
        this.files = files;
    }

    public void changeFileExtension(String current, String desired) {
        for (File file : files) {
            String fileName = file.getName().replaceAll(current, desired);
            file.renameTo(new File(fileName));
        }
    }
}
