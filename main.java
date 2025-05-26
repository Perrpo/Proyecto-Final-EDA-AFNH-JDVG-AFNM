import javax.swing.UIManager;

public class main {
    public static void main(String[] args) {
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        TechPartsHubGUI gui = new TechPartsHubGUI();
        gui.setVisible(true);
    }
}