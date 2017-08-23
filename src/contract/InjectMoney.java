package contract;

public class InjectMoney {
	public interface View extends Base.View {
		void onInjectSuccess(double newBalance);
	}
	
	public interface Presenter extends Base.Presenter {
		void injectMoney(double value);
		void onInjectSuccess(double newBalance);
	}
	
	public interface Model extends Base.Model {
		void injectMoney(double value);
	}
}
