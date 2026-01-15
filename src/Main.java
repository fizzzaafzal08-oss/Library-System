import view.LibraryGUI;
import controller.LibraryController;

public class Main {
    public static void main(String[] args) {
        LibraryGUI gui = new LibraryGUI();
        new LibraryController(gui);
        gui.setVisible(true);
    }
}
