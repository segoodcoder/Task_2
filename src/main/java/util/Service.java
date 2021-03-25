package util;

import java.io.*;
import java.io.FileInputStream;
import java.util.List;

public class Service {
    public static void u(String fileInputName) throws IOException {
        Reader r = new FileReader(fileInputName);
        BufferedReader br = new BufferedReader(r);
        StringBuilder sb = new StringBuilder();
        char ch = (char) br.read();
        while (ch != '~') {
            if (ch == '/') {
                if (br.read() == '/') {
                    ch = (char) br.read();
                    while (ch != ':') {
                        sb.append(ch);
                        ch = (char) br.read();
                    }
                }
            }
            FileWriter fw = new FileWriter(sb.toString());
            sb.delete(0, sb.length());
            ch = (char) br.read();
            while (ch != '/') {
                if (ch == '~') break;
                fw.write(ch);
                ch = (char) br.read();
            }
            fw.close();
        }
        br.close();
    }

    public static void out(List<String> listOfFiles, String outputName) throws IOException {
            int i;
            char slash = '/';
            char colon = ':';
            char tilda = '~';
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
                if (i == listOfFiles.size() - 1) {
                    fos.write(tilda);
                }
            }
            fos.close();
    }
}
