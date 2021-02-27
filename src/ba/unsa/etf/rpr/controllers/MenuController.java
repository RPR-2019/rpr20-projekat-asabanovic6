package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.exception.NonExistentDepartment;
import ba.unsa.etf.rpr.model.Employee;

import ba.unsa.etf.rpr.model.Location;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    public Label label1;
   private  Employee employee;


    public MenuController(Employee employee) {
        this.employee=employee;
    }

    public void departments (ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Departments.fxml"));
            DepartmentsController departmentsController = new DepartmentsController(employee);
            loader.setController(departmentsController);
            root = loader.load();
            stage.setTitle("Odjeli");
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            Stage thisStage = (Stage) label1.getScene().getWindow();
            thisStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void employees (ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EmployeesInDepartment.fxml"));
            EmployeesFromDepController employeesFromDepController = new EmployeesFromDepController(employee);
            loader.setController(employeesFromDepController);
            root = loader.load();
            stage.setTitle("Zaposleni");
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            Stage thisStage = (Stage) label1.getScene().getWindow();
            thisStage.close();
        } catch (IOException | NonExistentDepartment e) {
            e.printStackTrace();
        }
    }
   public void managers (ActionEvent actionEvent) {
       Stage stage = new Stage();
       Parent root = null;
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EmployeesInDepartment.fxml"));
           ManagersController managersController = new ManagersController(employee);
           loader.setController(managersController);
           root = loader.load();
           stage.setTitle("Menadžeri");
           stage.setScene(new Scene(root));
           stage.setMaximized(true);
           stage.setResizable(true);
           stage.show();
           Stage thisStage = (Stage) label1.getScene().getWindow();
           thisStage.close();
       } catch (IOException | NonExistentDepartment e) {
           e.printStackTrace();
       }
   }
    public void reports ( ActionEvent actionEvent) {

    }
    public void selfProfile (ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Profile.fxml"));
            ProfileController profileController = new ProfileController(employee);
            loader.setController(profileController);
            root = loader.load();
            stage.setTitle("Profil");
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            Stage thisStage = (Stage) label1.getScene().getWindow();
            thisStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logOut (ActionEvent actionEvent) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LogIn.fxml"));
            LogInController logInController = new LogInController();
            loader.setController(logInController);
            root = loader.load();
            stage.setTitle("Prijavi se");
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            Stage thisStage = (Stage) label1.getScene().getWindow();
            thisStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
