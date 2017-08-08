package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void write(String path, String text) throws IOException {
        FileWriter writer = new FileWriter(path, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(text);
        bufferedWriter.close();
        writer.close();
    }
}
