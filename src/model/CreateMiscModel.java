package model;

import contract.CreateMisc;
import mock.Database;
import mock.MiscDatabase;
import model.pojo.Misc;

public class CreateMiscModel implements CreateMisc.Model {

    private CreateMisc.Presenter presenter;

    public CreateMiscModel(CreateMisc.Presenter presenter) {
        this.presenter = presenter;
    }

    public void createMisc(Misc misc) {
        int result;
        try {
            result = Database.insert(MiscDatabase.PATH_MISCS, misc);
            misc.setId(result);
            presenter.onCreateSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }
}