package Main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author NaveenB2004
 */
public class HotspotMakerToolkit {

    public static String version = "0.2";
    
    public static void main(String[] args) {
        try {
            if (args[0].equals("-v")) {
                System.out.println(version);
            }
        } catch (Exception e) {
            setTheme();
            new UI.MainUI().setVisible(true);
        }
    }

    private static void setTheme() {
        try (Stream<String> lines = Files.lines(
                Paths.get("C:\\ProgramData\\NaveenB2004\\HospotMaker\\Theme.ini"))) {
            String theme = lines.skip(0).findFirst().get();
            if (theme.equals("Light")) {
                FlatLightLaf.setup();
            }
            if (theme.equals("Dark")) {
                FlatDarkLaf.setup();
            }
            if (theme.equals("Default")) {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
                        | UnsupportedLookAndFeelException e) {
                    Logger.getLogger(HotspotMakerToolkit.class.getName())
                            .log(Level.SEVERE, null, e);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(HotspotMakerToolkit.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }
}
