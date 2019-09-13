package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        Path path = Paths.get(file.getPath());
        // Path path = Paths.get("wrongdirectory/wrongfile.txt");

        try {
            //System.out.println(file.getPath());
            System.out.println(path);
            Stream<String> fileLines = Files.lines(path);
            fileLines.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Something is wrong with the path - " + e);

        } finally {
            System.out.println("This line will be always shown.");
        }

    }

    public void readFile2() throws FileReaderException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());

        try (Stream<String> fileLines = Files.lines(Paths.get("test.txt"))) {
            fileLines.forEach(System.out::println);

        } catch (IOException e) {
            throw new FileReaderException();

        } finally {
            System.out.println("This line will be always shown.");
        }

    }
}
