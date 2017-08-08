package view;

import contract.CreateItem;

public class CreateItemView extends BaseView implements CreateItem.View {

    public CreateItemView() {
        super();
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setTitle("Criar Item");
    }
}
