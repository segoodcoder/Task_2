package util;

import java.io.*;
import java.io.FileInputStream;
import java.util.List;

public class Service {
    public static void u(String fileInputName) throws IOException {
        Reader r = new FileReader(fileInputName);
        BufferedReader br = new BufferedReader(r);
        StringBuilder sb = new StringBuilder();
        int data = br.read();
        while (data != -1) {
            if ((char) data == '/') {
                data = br.read();
                if (data != -1 && (char) data == '/') {
                    data = br.read();
                    while (data != -1 && (char) data != ':') {
                        sb.append((char) data);
                        data = br.read();
                    }
                }
            }
            FileWriter fw = new FileWriter(sb.toString());
            sb.delete(0, sb.length());
            data = br.read();
            while (data != -1 && (char) data != '/') {
                fw.write(data);
                data = br.read();
            }
            fw.close();
        }
        br.close();
    }

    public static void out(List<String> listOfFiles, String outputName) throws IOException {
            int i;
            char slash = '/';
            char colon = ':';
        FileOutputStream fos = new FileOutputStream(outputName);
            for (i = 0; i < listOfFiles.size(); i++) {
                FileInputStream fs = new FileInputStream(listOfFiles.get(i));
                fos.write(slash);
                fos.write(slash);
                fos.write((listOfFiles.get(i)).getBytes());
                fos.write(colon);
                while (fs.available() > 0) {
                    fos.write(fs.read());
                }
                if (fs.available() == 0) {
                    fs.close();
                }
            }
            fos.close();
    }
}
