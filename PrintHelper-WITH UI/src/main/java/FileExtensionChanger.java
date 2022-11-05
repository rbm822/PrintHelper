package src.main.java;

import java.io.File;
import java.util.List;

public class FileExtensionChanger {
    public static void changeFileExtension(File file, String desiredExtension) {
        String current = file.getName();
        current = current.substring(file.getName().length() - 3, file.getName().length());
        String fileName = file.getName().replace(current, desiredExtension);
        file.renameTo(new File(".\\" + fileName));        // Renames file and maintains current dir.
    }
}
