package util;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Tar {

    Service s;

    public Tar(Service s) throws IOException {
        this.s = s;
    }

    public static void main(String[] args) throws Exception {
        parse(args);
    }

    public static void parse(String[] args) throws Exception {
        List<String> listOfFiles = new ArrayList<>();
        if (args.length < 3) {
            System.out.println("Неверное количество аргументов");
        }
        else {
            if (args[1].equals("-u")) {
                String fileInputName = args[2];
                Service.u(fileInputName);
            }
            else {
                String outputName = null;
                for (int i = 0; i <= args.length - 1; i++) {
                    if (args[i].equals("-out")) {
                        if (i == args.length - 2) {
                            outputName = args[i + 1];
                        }

                    }
                    listOfFiles.add(args[i]);
                }
                if (outputName != null) {
                    Service.out(listOfFiles, outputName);
                }
            }
        }

    }

}

