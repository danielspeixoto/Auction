package contract;

import model.pojo.Auction;

public class CreateAuction {

    public interface View extends Base.View {
    }

    public interface Presenter extends Base.Presenter {
        void createAuction(Auction auction);

        void onCreateSuccess();
    }

    public interface Model extends Base.Model {
        void createAuction(Auction auction);
    }

}
