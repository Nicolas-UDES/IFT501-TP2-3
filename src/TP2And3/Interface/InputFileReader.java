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
public class InputFileReader {
    String fileToRead;

    Map<String, List<Pair<Integer, Integer>>> wordMap;
    public InputFileReader(String file) {
        this.fileToRead = file;

        this.wordMap = new HashMap<>();
    }

    public void read() {
        System.out.println("Start reading file " + fileToRead);
        Path path = Paths.get(fileToRead);
        try {
            Files.lines(path).forEach(
                    (line) -> {
                        String[] splittedLine = line.split(",");

                        Integer docId = Integer.parseInt(splittedLine[0].replace("\"", ""));
                        String word = splittedLine[1].replace("\"", "");
                        Integer nTimes = Integer.parseInt(splittedLine[2].replace("\"", ""));

                        List<Pair<Integer, Integer>> wordList = wordMap.getOrDefault(word, new ArrayList<>());
                        wordList.add(new Pair(docId, nTimes));
                        wordMap.put(word, wordList);
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done reading file " + fileToRead);
    }

    Map<String, List<Pair<Integer, Integer>>> getWordMap() {
        return this.wordMap;
    }
}
