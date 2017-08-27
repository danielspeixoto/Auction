package util;

import model.pojo.Item;

public interface ItemTransmitter {

    void onItemReceived(Item item);
}
