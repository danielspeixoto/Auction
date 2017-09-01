package model;

import contract.CreateRealty;
import mock.Database;
import mock.RealtyDatabase;
import model.pojo.Realty;

public class CreateRealtyModel implements CreateRealty.Model {

    private CreateRealty.Presenter presenter;

    public CreateRealtyModel(CreateRealty.Presenter presenter) {
        this.presenter = presenter;
    }

    public void createRealty(Realty realty) {
        int result;
        try {
            result = Database.insert(RealtyDatabase.PATH_REALTIES, realty);
            realty.setId(result);
            presenter.onCreateSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            presenter.onError("Algum erro ocorreu");
        }
    }
}