package util;

import java.io.*;
import java.nio.Buffer;

public class Tar {
    Service s;
    public Tar(Service s) throws IOException {
        this.s = s;
    }
    public static void main(String[] args) throws IOException {
        Service s = new Service();
        Tar myTar = new Tar(s);
        myTar.parse(args);
    }
    public void parse(String[] args) throws IOException {
        if (args[2].equals("-u")) {
            Service.u(args);
        }
        else {
            Service.out(args);
        }
    }

}

