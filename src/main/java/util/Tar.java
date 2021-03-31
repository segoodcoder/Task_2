package util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tar {

    public static void main(String[] args) throws Exception {
        parse(args);
    }

    public static void parse(String[] args) throws Exception {
        Exception e = new IllegalArgumentException();
        List<String> listOfFiles = new ArrayList<>();
        if (args.length < 2) {
            System.out.println("Минимум 2 аргумента");
            throw e;
        }
        else {
            if (args[0].equals("-u") && args.length == 2 && !args[1].equals("-out")) {
                String fileInputName = args[1];
                    Service.u(fileInputName);
            }
            else if (Arrays.asList(args).contains("-out") && !Arrays.asList(args).contains("-u")) {
                String outputName = null;
                for (int i = 0; i <= args.length - 2; i++) {
                    if (args[i].equals("-out")) {
                        if (i == args.length - 2) {
                            outputName = args[i + 1];
                        }
                    }
                    if (!args[i].equals("-out") && args[i] != null) {
                        listOfFiles.add(args[i]);
                    }
                }
                if (outputName != null) {
                    Service.out(listOfFiles, outputName);
                }
            }
            else {
                System.out.println("Неверный формат данных. Правильно: tar -u filename.txt или\n" +
                    "tar file1.txt file2.txt ... -out output.txt.");
                throw e;
            }
        }
    }
}

