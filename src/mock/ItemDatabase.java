package mock;

import model.pojo.Item;
import util.Convert;
import util.ItemTransmitter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ItemDatabase extends Database {

    public static final int INDEX_OWNER = 1;
    public static final int INDEX_NAME = 2;
    public static final int INDEX_DESCRIPTION = 3;
    public static final int INDEX_TYPE = 4;
    public static final String PATH_ITEMS = "src//data//items.txt";

    public static void getAll(ItemTransmitter transmitter) {
        try (FileReader reader = new FileReader(PATH_ITEMS);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                transmitter.onItemReceived(Convert.itemFrom(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}