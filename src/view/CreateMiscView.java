package view;

import contract.CreateMisc;
import model.pojo.Misc;
import presenter.CreateMiscPresenter;
import util.Global;
import view.component.InputField;

import javax.swing.*;

public class CreateMiscView extends BaseView implements CreateMisc.View {

    private InputField descriptionField;
    private JButton submitButton;
    private CreateMisc.Presenter presenter;

    public CreateMiscView() {
        super();
        descriptionField = new InputField("Nome");
        descriptionField.setLocation(5, 5);
        submitButton = new JButton("Salvar");
        submitButton.setBounds(20, 20, 50, 50);
        submitButton.addActionListener(e ->
                presenter.createMisc(new Misc(Global.getCurrentUser().getId(), descriptionField.getText()))
        );
        add(descriptionField);
        add(submitButton);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setTitle("Criar Misc");
        presenter = new CreateMiscPresenter(this);
    }

    @Override
    public void onCreateSuccess(Misc misc) {
        frame.setResult(misc);
    }

}
