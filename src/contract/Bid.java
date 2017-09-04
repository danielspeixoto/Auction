package contract;

import model.pojo.Auction;

public class Bid {

    public interface View extends Base.View {
        void onBidSuccess();
    }

    public interface Presenter extends Base.Presenter {
        void bid(Auction auction);
        void onBidSuccess();
    }

    public interface Model extends Base.Model {
        void bid(Auction auction);
    }
}
