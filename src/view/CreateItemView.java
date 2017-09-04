package view;

public class CreateItemView extends BaseView {

    public static final int ITEM_SENDER = 0;

    public void sendResult(Object result) {
        frame.setResult(ITEM_SENDER, result);
    }
}
