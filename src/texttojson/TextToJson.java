/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttojson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tarek_awwad
 */
public class TextToJson {

    public TextToJson(String input) {
        StringTokenizer st = new StringTokenizer(input, "\n");
        int numDocuments = st.countTokens() - 1;
        System.out.print(numDocuments + "\n\n");

        String record; // skip empty split to left of {

        for (int i = 1; i <= numDocuments + 1; i = i + 10) {
            record = st.nextToken();
            for (int j = 0; j < 10; j++) {
           
                String s[] = record.split("\t");
                System.out.print("{\"content\": " + "\"" + s[1] + "\"" + ", " + "\"id\": " + (i + j) + ", " + "\"title\": " + "\"" + s[0] + "\"" + "}");
//            System.out.print( ">>>>" + i + " : " + s[0] + "\n");

//                long documentID = Long.parseLong(matcher.group(2));
//                String title = matcher.group(3);
//                String contents = matcher.group(1);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String input;
        StringBuilder everything = new StringBuilder();
        if (args.length > 0) {
            BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));

            while ((input = in.readLine()) != null) {
                everything.append(input + "\n");
            }
        }
        TextToJson ttj = new TextToJson(everything.toString());
    }
}
