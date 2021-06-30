package sample;


import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Model {

   protected static int Authorization(String login2, String password2) throws FileNotFoundException {
        HashMap<Integer, String> adminHashMap = new HashMap<Integer,String>();
        HashMap<Integer, String> sysAdminHashMap = new HashMap<Integer,String>();
        HashMap<Integer, String> usersHashMap = new HashMap<Integer,String>();

        LinkedList<User> userLinkedList = new LinkedList<User>();
        LinkedList<Admin> adminLinkedList = new LinkedList<Admin>();
        LinkedList<SysAdmin> sysAdminLinkedList = new LinkedList<SysAdmin>();


        FileReader adminReader = new FileReader("C://Users//Admin//IdeaProjects//apllicationJava//dataAdmin//admin.txt");
        Scanner scanAdmin = new Scanner(adminReader);

        FileReader sysAdminReader = new FileReader("C://Users//Admin//IdeaProjects//apllicationJava//dataAdmin//sysAdmin.txt");
        Scanner scanSysAdmin = new Scanner(sysAdminReader);

        FileReader usersReader = new FileReader("C://Users//Admin//IdeaProjects//apllicationJava//dataAdmin//user.txt");
        Scanner scanUsers = new Scanner(usersReader);


        int i = 1, l = 1, m = 1; //Index of Objects
        int g = 0;




        //Добвляем в коллекцию данные с файла

        while (scanAdmin.hasNextLine()){
            adminHashMap.put(i++,scanAdmin.nextLine());
        }

        while (scanSysAdmin.hasNextLine()){
            sysAdminHashMap.put(l++,scanSysAdmin.nextLine());
        }

        while (scanUsers.hasNextLine()){
            usersHashMap.put(m++,scanUsers.nextLine());
        }

        //Проверяем введенные данные
        g = dataFilling(login2, password2, adminHashMap, sysAdminHashMap, usersHashMap, userLinkedList, adminLinkedList, sysAdminLinkedList);
       // printLinkedList( userLinkedList, adminLinkedList, sysAdminLinkedList);

       return g;

    }

    public  static  void printLinkedList(LinkedList<User> userLinkedList,  LinkedList<Admin> adminLinkedList, LinkedList<SysAdmin> sysAdminLinkedList) {
        System.out.println("User:");
        for (User us : userLinkedList) {
            System.out.println();
            System.out.println(us.getName());
            System.out.println(us.getSurname());
            System.out.println(us.getLogin());
            System.out.println(us.getPassword());
            System.out.println();
        }
        System.out.println("Admin\n");
        for (Admin ad: adminLinkedList){
            System.out.println();
            System.out.println(ad.getName());
            System.out.println(ad.getSurname());
            System.out.println(ad.getLogin());
            System.out.println(ad.getPassword());
            System.out.println();
        }

        System.out.println("SysAdmin\n");
        for (SysAdmin sys: sysAdminLinkedList){
            System.out.println();
            System.out.println(sys.getName());
            System.out.println(sys.getSurname());
            System.out.println(sys.getLogin());
            System.out.println(sys.getPassword());
            System.out.println();
        }


    }


    public static int dataFilling(String login,
                                   String password,
                                   HashMap<Integer, String> adminList,
                                   HashMap<Integer, String> sysAdminList,
                                   HashMap<Integer, String> usersList,
                                   LinkedList<User> userLinkedList,
                                   LinkedList<Admin> adminLinkedList,
                                   LinkedList<SysAdmin> sysAdminLinkedList)
    {

        int count = 1; // Admin
        int count2 = 1;// SysAdmin
        int count3 = 1;// User

        String name = "";
        String surname = "";
        String login1 = "";
        String password1 = "";
        System.out.println(login);
        System.out.println(password);


        boolean chLoginAdmin = false;
        boolean chPasswordAdmin = false;

        boolean chLoginSysAdmin = false;
        boolean chPasswordSysAdmin = false;

        boolean chLoginUser = false;
        boolean chPasswordUser = false;

        System.out.println("Admin Data: " + '\n');


        for (Map.Entry<Integer, String> itemAdmin : adminList.entrySet()) {

            switch (count){
                case 1:
                    name = itemAdmin.getValue();
                   // System.out.printf("Name: %s\n", itemAdmin.getValue());
                    break;
                case 2:
                    surname = itemAdmin.getValue();
                   // System.out.printf("Surname: %s\n", itemAdmin.getValue());
                    break;
                case 3:

                    login1 = itemAdmin.getValue();
                    //System.out.printf("Login: %s\n", itemAdmin.getValue());
                    break;
                case 4:
                    password1 =  itemAdmin.getValue();
                   // System.out.printf("Password: %s\n", itemAdmin.getValue());
                    adminLinkedList.add(new Admin(name, surname, login1, password1));
                    break;
                case 5:

                    System.out.println();count = 0;
                    break;
            }

            if (itemAdmin.getValue().equals(login))
                chLoginAdmin = true;

            if (itemAdmin.getValue().equals(password))
                chPasswordAdmin = true;

            if (chLoginAdmin == true && chPasswordAdmin == true) {
                chPasswordAdmin  = false;
                chLoginAdmin = false;
                System.out.println("Авторизация прошла успешно !" +  "  " + itemAdmin.getValue());
                return 2;

            }


            count++;
        }

//        System.out.printf("----------------------------------------------------------------\n" +
//                "----------------------------------------------------------------\n\n");
//        System.out.println("System Admin Data: " + '\n');



        for (Map.Entry<Integer, String> itemSysAdmin : sysAdminList.entrySet()){
            switch (count2){
                case 1:
                    name = itemSysAdmin.getValue();
                    //System.out.printf("Name: %s\n", itemSysAdmin.getValue());
                    break;
                case 2:
                    surname = itemSysAdmin.getValue();
                    //System.out.printf("Surname: %s\n", itemSysAdmin.getValue());
                    break;
                case 3:
                    login1 = itemSysAdmin.getValue();
                    //System.out.printf("Login: %s\n", itemSysAdmin.getValue());
                    break;
                case 4:
                    password1 = itemSysAdmin.getValue();
                 //  System.out.printf("Password: %s\n", itemSysAdmin.getValue());
                    sysAdminLinkedList.add(new SysAdmin(name, surname, login1, password1));
                    break;
                case 5:

                    System.out.println();count2 = 0;
                    break;
            }

            if (itemSysAdmin.getValue().equals(login))
                chLoginSysAdmin = true;

            if (itemSysAdmin.getValue().equals(password))
                chPasswordSysAdmin = true;

            if (chLoginSysAdmin == true && chPasswordSysAdmin == true) {
                chPasswordSysAdmin  = false;
                chLoginSysAdmin = false;
               // System.out.println("Авторизация прошла успешно !" + "  " + itemSysAdmin.getValue());
                return 1;
            }

            count2++;


        }


//        System.out.printf("----------------------------------------------------------------\n" +
//                "----------------------------------------------------------------\n\n");
//        System.out.println("Users: " + '\n');
        for (Map.Entry<Integer, String> itemUsers : usersList.entrySet()){

            switch (count3){
                case 1:
                    name =  itemUsers.getValue();
                    //System.out.printf("Name: %s\n", itemUsers.getValue());
                    break;
                case 2:
                    surname =  itemUsers.getValue();
                   // System.out.printf("Surname: %s\n", itemUsers.getValue());
                    break;
                case 3:
                    login1 =  itemUsers.getValue();
                   // System.out.printf("Login: %s\n", itemUsers.getValue());
                    break;
                case 4:
                    password1 =  itemUsers.getValue();
                   // System.out.printf("Password: %s\n", password1);
                    userLinkedList.add(new User(name, surname, login1, password));
                    break;
                case 5:

                    System.out.println();count3 = 0;
                    break;
            }

            if (itemUsers.getValue().equals(login))
                chLoginUser = true;

            if (itemUsers.getValue().equals(password))
                chPasswordUser = true;

            if (chLoginUser== true && chPasswordUser == true) {
                chPasswordUser  = false;
                chLoginUser = false;
              //  System.out.println("Авторизация прошла успешно !"  + "  " + itemUsers.getValue());
                return 3;
            }
            count3++;
        }

return 0;
    }

}
