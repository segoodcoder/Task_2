import org.junit.Test;
import org.junit.*;
import util.Service;
import util.Tar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tar_tests {

    @Test
    public void out() throws IOException {
        String[]args = {"file1.txt", "file2.txt", "-out", "output.txt"};
        Service.out(args);
        Assert.assertTrue(fileEquals("expected.txt", "output.txt"));
    }

    @Test
    public void u() throws IOException {
        String[]args = {"tar", "-u", "output.txt"};
        Service.u(args);
        Assert.assertTrue(fileEquals("test1.txt", "file1.txt"));
        Assert.assertTrue(fileEquals("test2.txt", "file2.txt"));
    }

    public boolean fileEquals(String name1, String name2) throws IOException {
        FileInputStream fs1 = new FileInputStream(name1);
        FileInputStream fs2 = new FileInputStream(name2);
        while (fs1.available() > 0) {
            while (fs2.available() > 0) {
                if (fs1.read() != fs2.read()) {
                    fs1.close();
                    fs2.close();
                    return false;
                }
            }
        }
        fs1.close();
        fs2.close();
        return true;
    }



}
