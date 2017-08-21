package contract;

public class InjectMoney {
	public interface View extends Base.View {
		void onInjectSuccess();
	}
	
	public interface Presenter extends Base.Presenter {
		void injectMoney(double value);
		void onInjectSuccess();
	}
	
	public interface Model extends Base.Model {
		void injectMoney(double value);
	}
}
