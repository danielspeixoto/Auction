package view;

import contract.CreateItem;
import model.pojo.Item;
import presenter.CreateItemPresenter;
import util.Global;
import view.component.InputField;
import view.component.SimpleButton;

import javax.swing.*;

public class CreateItemView extends BaseView implements CreateItem.View {

	private InputField nameField;
    private InputField descriptionField;
    private SimpleButton submitButton;
    private CreateItem.Presenter presenter;

    public CreateItemView() {
        super();
        nameField = new InputField("Nome");
        nameField.setLocation(10, 10);
        descriptionField = new InputField("Descrição");
        descriptionField.setLocation(10, 50);
        submitButton = new JButton("Salvar");
        submitButton.setBounds(20, 90, 50, 50);
        submitButton = new SimpleButton("Salvar");
        submitButton.setLocation(75, 80);
        submitButton.addActionListener(e ->
                presenter.createItem(new Item(Global.getCurrentUser().getId(), nameField.getText(), descriptionField.getText()))
        );
        add(descriptionField);
        add(submitButton);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 450);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Criar Item");
        presenter = new CreateItemPresenter(this);
    }

    @Override
    public void onCreateSuccess(Item item) {
        frame.setResult(item);
    }
}
