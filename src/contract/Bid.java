package contract;

import model.pojo.Auction;

public class Bid {

    public interface View extends Base.View {
        void onBidSuccess(Auction auction);
    }

    public interface Presenter extends Base.Presenter {
        void bid(Auction auction, double value);
        void onBidSuccess(Auction auction);
    }

    public interface Model extends Base.Model {
        void bid(Auction auction, double value);
    }
}
