package ro.ase.cts.composite;

import java.util.List;
import java.util.ArrayList;

interface FileSystemItem {
    void printName();
}

class File implements FileSystemItem {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println("File: " + name);
    }
}

class Folder implements FileSystemItem {
    private List<FileSystemItem> items = new ArrayList<>();
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println("Folder: " + name);
        for (FileSystemItem item : items) {
            item.printName();
        }
    }

    public void addItem(FileSystemItem item) {
        items.add(item);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        //Creating files
        File file1 = new File("File1.txt");
        File file2 = new File("File2.docx");
        File file3 = new File("File3.pdf");

        //Creating root folder
        Folder rootFolder = new Folder("RootFolder");

        //Adding files to root folder
        rootFolder.addItem(file1);
        rootFolder.addItem(file2);
        rootFolder.addItem(file3);

        //Creating subfolder
        Folder subFolder = new Folder("SubFolder");

        //Adding files to subfolder
        subFolder.addItem(file3);

        // Adding subfolder to root folder
        rootFolder.addItem(subFolder);

        //Printing root folder
        rootFolder.printName();
    }
}
