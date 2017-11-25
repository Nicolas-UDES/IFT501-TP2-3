package TP2And3.Interface;

import TP2And3.Algorithm.FuzzyCMeans;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.SparseDoubleMatrix2D;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		InputFileReader fileReader = new InputFileReader("output.txt");
		fileReader.read();

        Map<String, List<Pair<Integer, Integer>>> wordMap = fileReader.getWordMap();
        SparseDoubleMatrix2D matrix = InputMatrixGenerator.generateMatrix(wordMap);
        FuzzyCMeans fcm = new FuzzyCMeans();
        fcm.cluster(matrix, 5);

        DoubleMatrix2D partitions = fcm.getPartition();
        Path path = Paths.get("out_matrice.txt");
        try {


            BufferedWriter bf = Files.newBufferedWriter(path);
            for (int i = 0; i < 1000; ++i) {
                for (int j = 0; j < 10; ++j) {
                    bf.write(Double.toString(partitions.getQuick(i, j)) + " ");
                    bf.flush();
                }
                bf.newLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done !");
	}
}
