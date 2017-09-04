package contract;

import model.pojo.Auction;

public class Home {

    public interface View extends Base.View {
        void onReceiveAuction(Auction auction);
        void clearAuctions();
    }

    public interface Presenter extends Base.Presenter {
        void syncAuctions();
        void onReceiveAuction(Auction auction);
    }

    public interface Model extends Base.Model {
        void getAuctions();
    }
}
