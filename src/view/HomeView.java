package view;


public class HomeView extends BaseView {

    public HomeView() {
        super();
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 250);
        frame.setTitle("Tela Inicial");
    }
}
