package TP2And3.Interface;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dominic on 11/24/17.
 */
public class IndexFileReader {
    String fileToRead;

    List<String> pathList;
    public IndexFileReader(String file) {
        this.fileToRead = file;

        this.pathList = new ArrayList<>();
    }

    public void read() {
        System.out.println("Start reading file " + fileToRead);
        Path path = Paths.get(fileToRead);
        try {
            Files.lines(path).forEach(
                    (line) -> {
                        String[] splittedLine = line.split("\t");

                        Integer docId = Integer.parseInt(splittedLine[0]);
                        String file = splittedLine[1];
                        String p = "ab";

                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done reading file " + fileToRead);

    }
}
