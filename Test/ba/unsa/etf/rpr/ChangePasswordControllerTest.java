package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.controllers.ChangePasswordController;
import ba.unsa.etf.rpr.controllers.LogInController;
import ba.unsa.etf.rpr.utilities.HrDAO;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(ApplicationExtension.class)
public class ChangePasswordControllerTest {
    Stage theStage;
    ChangePasswordController ctrl;
    HrDAO dao;

    @Start
    public void start (Stage primaryStage) throws Exception {
        dao = HrDAO.getInstance();
        dao.returnBaseOnDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("Translation");
        FXMLLoader loader = new FXMLLoader( getClass().getResource("/fxml/ChangePassword.fxml" ), bundle);
        Locale.setDefault(new Locale("bs", "BA"));
        ChangePasswordController ctrl = new ChangePasswordController(dao.getEmployee(1));
        loader.setController(ctrl);
        Parent root = loader.load();
        primaryStage.setTitle(bundle.getString("Change_password"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.show();
        theStage=primaryStage;
    }
    @BeforeEach
    public void resetDataBase() throws SQLException {
        dao.returnBaseOnDefault();
    }

    @AfterEach
    public void closeTheWindow(FxRobot robot) {
        if (robot.lookup("#btnCancel").tryQuery().isPresent())
            robot.clickOn("#btnCancel");
    }
    @Test
    public void testChangePassword(FxRobot robot) {

        robot.clickOn("#BtnOk");


        TextField ime = robot.lookup("#fieldOldPassword").queryAs(TextField.class);
        Background bg = ime.getBackground();
        boolean colorFound = false;
        for (BackgroundFill bf : bg.getFills())
            if (bf.getFill().toString().contains("ffb6c1"))
                colorFound = true;
        assertTrue(colorFound);


        robot.lookup(".dialog-pane").tryQuery().isPresent();


        DialogPane dialogPane = robot.lookup(".dialog-pane").queryAs(DialogPane.class);
        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        robot.clickOn(okButton);



        robot.clickOn("#fieldOldPassword");
        robot.write("password");
        robot.clickOn("#fieldNewPassword");
        robot.write("password");
        robot.clickOn("#fieldNewPasswordSec");
        robot.write("password");

        robot.clickOn("#BtnOk");

        assertFalse(theStage.isShowing());
    }
}
