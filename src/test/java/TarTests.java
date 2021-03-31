import org.junit.Test;
import org.junit.*;
import org.junit.function.ThrowingRunnable;
import util.Service;
import util.Tar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TarTests {


    @Test
    public void out() throws Exception {
        Service.out(List.of("text1.txt", "text2.txt"),"actual.txt");
        Assert.assertTrue(fileEquals("expected.txt", "actual.txt"));
    }

    @Test
    public void u() throws IOException {
        Service.u("expected_u.txt");
        Assert.assertTrue(fileEquals("test1.txt", "text1.txt"));
        Assert.assertTrue(fileEquals("test2.txt", "text2.txt"));
    }

    @Test
    public void mainTestOutNormal() throws Exception {
        String[] args = {"text1.txt", "text2.txt", "-out", "outputFile1.txt"};
        Tar.main(args);
        Assert.assertTrue(fileEquals("expected.txt", "outputFile1.txt"));
     }

    @Test
    public void mainTestUNormal() throws Exception {
        String[] args = {"-u", "expected_u.txt"};
        Tar.main(args);
        Assert.assertTrue(fileEquals("test1.txt", "text1.txt"));
        Assert.assertTrue(fileEquals("test2.txt", "text2.txt"));
    }

    @Test
    public void singleArgument() {
        String[] args = {""};
        Assert.assertThrows(IllegalArgumentException.class, () -> Tar.parse(args));
    }

    @Test
    public void noSuchFile() {
        String[] args = {"-u", "a.txt"};
        Assert.assertThrows(FileNotFoundException.class, () -> Tar.parse(args));
    }

    @Test
    public void twoKeys() {
        String[] args = {"-u", "-out"};
        Assert.assertThrows(IllegalArgumentException.class, () -> Tar.parse(args));
    }

    @Test
    public void emptyKeys() {
        String[] args = {"", "", ""};
        Assert.assertThrows(IllegalArgumentException.class, () -> Tar.parse(args));
    }

    @Test
    public void uEmptyKey() {
        String[] args = {"-u", ""};
        Assert.assertThrows(FileNotFoundException.class, () -> Tar.parse(args));
    }


    public boolean fileEquals(String name1, String name2) throws IOException {
        FileReader fr1 = new FileReader(name1);
        BufferedReader br1 = new BufferedReader(fr1);
        ArrayList<String> l1 = new ArrayList<>();
        FileReader fr2 = new FileReader(name2);
        BufferedReader br2 = new BufferedReader(fr2);
        ArrayList<String> l2 = new ArrayList<>();
        String s1;
        String s2;
        s1 = br1.readLine();
        while (s1 != null) {
            l1.add(s1);
            s1 = br1.readLine();
        }
        s2 = br2.readLine();
        while (s2 != null) {
            l2.add(s2);
            s2 = br2.readLine();
        }
        return l1.equals(l2);
    }



}
