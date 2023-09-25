package lockedme.businesslogic;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileOperations {
    private Scanner sc = new Scanner(System.in);

    public void sortFileNames() {
        System.out.print("Enter a path: ");
        String path = sc.nextLine();
        File file = new File(path);
        
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                List<File> fileList = Arrays.asList(files);
                fileList.sort(Comparator.comparing(File::getName));
                fileList.forEach(f -> System.out.println(f.getName()));
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The specified path is not a directory.");
        }
    }

    public void addFile() {
        System.out.print("Enter the path with the name of the file you want to create: ");
        String fileName = sc.nextLine();
        File newFile = new File(fileName);

        try {
            if (newFile.createNewFile()) {
                System.out.print("Enter the file content: ");
                String content = sc.nextLine();
                try (FileWriter writer = new FileWriter(newFile)) {
                    writer.write(content);
                }
                System.out.println("File is saved at the given location.");
            } else {
                System.out.println("File '" + fileName + "' already exists.");
            }
        } catch (IOException e) {
            System.out.println("Failed to create the file " + fileName);
            e.printStackTrace();
        }
    }

    public void deleteFile() {
        System.out.print("Enter the path of the file you want to delete: ");
        String fileName = sc.nextLine();
        File file = new File(fileName);

        if (file.exists()) {
            if (file.isFile()) {
                if (file.delete()) {
                    System.out.println("File '" + fileName + "' deleted successfully.");
                } else {
                    System.out.println("Failed to delete the file " + fileName);
                }
            } else {
                System.out.println("'" + fileName + "' is not a file.");
            }
        } else {
            System.out.println("File '" + fileName + "' does not exist.");
        }
    }

    public void searchFile() {
        System.out.print("Enter the file directory: ");
        String path = sc.nextLine();
        System.out.print("Enter the file name to search: ");
        String fileName = sc.nextLine();
        File directory = new File(path);

        if (directory.isDirectory()) {
            List<String> fileNames = Arrays.stream(Objects.requireNonNull(directory.list()))
                    .collect(Collectors.toList());

            if (fileNames.contains(fileName)) {
                System.out.println("File found.");
            } else {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("The specified path is not a directory.");
        }
    }
}