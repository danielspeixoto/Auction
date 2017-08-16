package contract;

public class InjectMoney {
	public interface View extends Base.View {
	}
	
	public interface Presenter extends Base.Presenter {
		void injectMoney(double value);
	}
	
	public interface Model extends Base.Model {
	}
}
