package TP2And3.Interface;

import cern.colt.matrix.impl.SparseDoubleMatrix2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by dominic on 11/24/17.
 */
public class InputMatrixGenerator {
    private static Integer N_DOCUMENTS = 128803;
    private static Integer MAX_DOCUMENTS = 1000;

    public static SparseDoubleMatrix2D generateMatrix(Map<String, List<Pair<Integer, Integer>>> wordMap) {
        System.out.println("Start Generating matrix");
        Set<Map.Entry<String, List<Pair<Integer, Integer>>>> entrySet = wordMap.entrySet();
        List<String> wordList = new ArrayList<>();
        SparseDoubleMatrix2D matrix = new SparseDoubleMatrix2D(MAX_DOCUMENTS, entrySet.size());


        for (Map.Entry<String, List<Pair<Integer, Integer>>> entry : entrySet) {
            Integer wordIndex = wordList.size();
            List<Pair<Integer, Integer>> documentsList = entry.getValue();
            wordList.add(entry.getKey());

            for (Pair<Integer, Integer> document : documentsList) {
                Integer documentIndex = document.getFirst() - 1;
                Integer nTimes = document.getSecond();
                if (documentIndex < MAX_DOCUMENTS) {
                    matrix.setQuick(documentIndex, wordIndex, 1);
                }
            }
        }

        System.out.println("Done Generating matrix");

        return matrix;
    }
}
