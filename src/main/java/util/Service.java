package util;

import java.io.*;
import java.io.FileInputStream;

public class Service {
    public static void u(String[] args) throws IOException {
        FileInputStream fs = new FileInputStream(args[2]);
        int counter = 1;
        String baseFileName = "test";
        String extention = ".txt";
        char slash = '/';
        int slashCode = (int) slash;
        FileOutputStream fos = new FileOutputStream(baseFileName + counter + extention);
        while (fs.available() > 0) {
            int data = fs.read();
            if (data != slashCode) {
                fos.write(data);
            } else {
                if (fs.read() == slashCode) {
                    fos.close();
                    counter++;
                    fos = new FileOutputStream(baseFileName + counter + extention);
                }
            }
        }
    }
    public static void out(String[] args) throws IOException {
            int i = 0;
            Character slash = '/';
            int slashCode = (int) slash;
            FileOutputStream fos = new FileOutputStream(args[args.length - 1]);
            while(!args[i].equals("-out")) {
                FileInputStream fs = new FileInputStream(args[i]);
                while (fs.available() > 0) {
                    fos.write(fs.read());
                }
                if (!args[i+1].equals("-out")) {
                    fos.write(slashCode);
                    fos.write(slashCode);
                }
                fs.close();
                i++;
            }
            fos.close();
    }
}
