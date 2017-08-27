package contract;

import model.pojo.Item;

public class Home {

    public interface View extends Base.View {
        void onReceiveItem(Item item);
    }

    public interface Presenter extends Base.Presenter {
        void getAuctions();
        void onReceiveItem(Item item);
    }

    public interface Model extends Base.Model {
        void getAuctions();
    }
}
