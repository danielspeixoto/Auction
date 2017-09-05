package presenter;

import contract.CreateAuction;
import model.CreateAuctionModel;
import model.pojo.Auction;
import util.Validate;

public class CreateAuctionPresenter implements CreateAuction.Presenter {

    private CreateAuction.View view;
    private CreateAuction.Model model;

    public CreateAuctionPresenter(CreateAuction.View view) {
        this.view = view;
        this.model = new CreateAuctionModel(this);
    }

    @Override
    public void createAuction(Auction auction) {
        String result = Validate.validate(auction);
        if (result.equals(Validate.OK)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    model.createAuction(auction);
                }
            }).start();
        } else {
            view.showErrorDialog(result);
        }
    }

    @Override
    public void onCreateSuccess() {
        view.onCreateSuccess();
        view.close();
    }

    @Override
    public void onError(String message) {
        view.showErrorDialog(message);
    }
}
