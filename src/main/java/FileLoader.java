package src.main.java.utils;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    private String directory;
    private String fileTypeToLoad;
    private FileNameExtensionFilter extensionFilter;
    private List<File> validatedFileList;

    public FileLoader(String directory, String fileTypeToLoad) {
        this.directory = directory;
        this.fileTypeToLoad = fileTypeToLoad;
        this.extensionFilter = new FileNameExtensionFilter("PDF", fileTypeToLoad);
        this.validatedFileList = new ArrayList<>();
    }

    public List<File> getFilesFromDirectory() {
        File[] filesFromDirectory = new File(directory).listFiles();

        for (File file : filesFromDirectory) {
            if (isDesiredFileType(file)) {
                add(validatedFileList, file);
            }
        }

        return validatedFileList;
    }

    private void add(List<File> fileList, File file) {
        fileList.add(file);
    }

    private boolean isDesiredFileType(File file) {
        return extensionFilter.accept(file);
    }
}
