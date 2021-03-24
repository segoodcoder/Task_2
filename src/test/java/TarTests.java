import org.junit.Test;
import org.junit.*;
import util.Service;
import util.Tar;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
