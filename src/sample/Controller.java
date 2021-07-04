package sample;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.*;


import javafx.fxml.FXML;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Controller {

    @FXML
    TextField loginField = new TextField();

    @FXML
    PasswordField passwordField = new PasswordField();

    String loginEnter = loginField.getText();
    String passwordEnter = passwordField.getText();

    int levelAccess = 0;
    Model mod = new Model();
    MainView view = new MainView();

    //Back Button (List of Items and Supplier

  @FXML
    Button btnBackRemove = new Button();

    // Authorization Button

    @FXML
    Button btnSignIn = new Button();

    @FXML
    Button btnSignOutUser = new Button();

    @FXML
    Button btnSignOutAdmin = new Button();

    @FXML
    Button btnSignOutSysAdmin = new Button();


    //  Menu Button



    @FXML
    Button btnRemoveUser = new Button();
    Button btnRemoveAdmin = new Button();
    Button btnRemoveSysAdmin = new Button();


    //System Admin settings

    @FXML
    Button sysBtnAdd = new Button();
    Button sysBtnRemove= new Button();
    Button sysBtnChange = new Button();

    //---------------------------------------------------------------------
    //                  AUTHORIZATION
    //---------------------------------------------------------------------

    public void click() {
        btnSignIn.setOnAction(event -> {
            levelAccess = accessLevelAuthorizathion();

            switch (levelAccess) {

                case 1:
                    view.menuSystemAdmin();

                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    break;
                case 2:
                    System.out.println("Hi Admin");
                    view.menuAdmin();


                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    break;
                case 3:
                    System.out.println("Hi User");
                    view.meniUser();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    break;

                default:
                    System.out.println("Why here error :(");
            }
        });



    }

    //---------------------------------------------------------------------
    //                      MAIN BUTTON (LIST)
    //---------------------------------------------------------------------
    @FXML
    Button btnListUser = new Button();
    @FXML
    Button btnListAdmin = new Button();
    @FXML
    Button btnListSysAdmin = new Button();

    @FXML
    Button btnBackList = new Button();


    @FXML
    Button btnOkListOfUser = new Button();
    @FXML
    Button btnOkListOfAdmin = new Button();
    @FXML
    Button btnOkListOfSysAd = new Button();


    public void clickListUser(){

        btnListUser.setOnAction(event -> {
            view.listOfUs();
            System.out.println("HI");
            ((Node) (event.getSource())).getScene().getWindow().hide();
        });
    }
    public void clickListAdmin(){

        btnListAdmin.setOnAction(event -> {
            view.listOfAd();
            System.out.println("HI");
            ((Node) (event.getSource())).getScene().getWindow().hide();
        });
    }
    public void clickListSys(){

        btnListSysAdmin.setOnAction(event -> {
            view.listOfSys();
            System.out.println("HI");
            ((Node) (event.getSource())).getScene().getWindow().hide();
        });
    }


    public void clickBackUserListof(){

        btnBackList.setOnAction(event -> {
            view.meniUser();

            ((Node) (event.getSource())).getScene().getWindow().hide();
        });
    }
    public void clickBackAdminListof(){

        btnBackList.setOnAction(event -> {
            view.menuAdmin();

            ((Node) (event.getSource())).getScene().getWindow().hide();
        });
    }
    public void clickBackSysAdminListof(){

        btnBackList.setOnAction(event -> {
            view.menuSystemAdmin();

            ((Node) (event.getSource())).getScene().getWindow().hide();
        });
    }

    public void clickOkListOfAdmin(){
        btnOkListOfAdmin.setOnAction(er->{
            try {
                Model.fillingTheCollectionItems();
                System.out.println("Admin");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    public void clickOkListOfUser(){
        btnOkListOfUser.setOnAction(ee->{
            try {
                Model.fillingTheCollectionItems();
                System.out.println("User");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    public void clickOkListOfSysAdmin(){
        btnOkListOfSysAd.setOnAction(et->{
            try {
                Model.fillingTheCollectionItems();
                System.out.println("Sys Admin");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    //---------------------------------------------------------------------
    //                      MAIN BUTTON (ADD Items / Supplier)
    //---------------------------------------------------------------------
    @FXML
    Button btnAddUser = new Button();
    @FXML
    Button btnAddAdmin = new Button();
    @FXML
    Button btnAddSysAdmin = new Button();

    @FXML
    Button btnBackAdd = new Button();
    public void addItemsSupplierUser(){}
    public void addItemsSupplierAdmin(){}
    public void addItemsSupplierSysAdmin(){}

    public void  clickBackSysAdminAdd(){}
    public void  clickBackAdminAdd(){}
    public void  clickBackUserAdd(){}

    //---------------------------------------------------------------------
    //                      MAIN BUTTON (CHANGE Items / Supplier)
    //---------------------------------------------------------------------
    @FXML
    Button btnChangeUser = new Button();
    @FXML
    Button btnChangeAdmin = new Button();
    @FXML
    Button btnChangeSysAdmin = new Button();

    @FXML
    Button btnBackChange = new Button();
    public void changeItemsSupplierUser(){}
    public void changeItemsSupplierAdmin(){}
    public void changeItemsSupplierSysAdmin(){}

    public void  clickBackSysAdminChange(){}
    public void  clickBackAdminChange(){}
    public void  clickBackUserChange(){}

    //---------------------------------------------------------------------
    //                      BACK BUTTON
    //---------------------------------------------------------------------

    public  void clickBackSysAdmin(){
        btnSignOutSysAdmin.setOnAction(e1 -> {

            try {
                view.Authorizathion();
             ((Node) (e1.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public void clickBackAdmin(){
        btnSignOutAdmin.setOnAction(e2 ->{
            try {
                view.Authorizathion();
                ((Node) (e2.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public void  clickUser(){
        btnSignOutUser.setOnAction(e3 -> {
            try {
                view.Authorizathion();
                ((Node) (e3.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }



    //---------------------------------------------------------------------
    //                      ACCESS LEVEL CHECK
    //---------------------------------------------------------------------


    public int accessLevelAuthorizathion() {


        if (!((loginField.getText().equals("") || !loginField.getText().equals(" ")) && (passwordField.getText().equals("") || passwordField.getText().equals(" ")))) {
            System.out.println(loginEnter);
            System.out.println(passwordEnter);

            try {
                levelAccess = Model.Authorization(loginField.getText(), passwordField.getText());
                return  levelAccess;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            System.out.printf("Access!  your access level %d", levelAccess);
        } else {
            System.out.println("Введите данные !!!");
            return 0;
        }
        return -1;
    }
}