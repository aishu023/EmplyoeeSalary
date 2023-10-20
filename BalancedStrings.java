import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {    

    public static void main(String[] args) {
        Regex_Test tester = new Regex_Test();
        tester.checker("^(?=(?:[^a]*a[^a]*a)*(?:[^c]*c[^c]*c)*(?:[^b]*b[^b]*b)*(?:[^d]*d[^d]*d)*$)");
    }
}