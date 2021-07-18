package sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import  java.lang.*;


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

        while (scanAdmin.hasNextLine())
            adminHashMap.put(i++,scanAdmin.nextLine());


        while (scanSysAdmin.hasNextLine())
            sysAdminHashMap.put(l++,scanSysAdmin.nextLine());


        while (scanUsers.hasNextLine())
            usersHashMap.put(m++,scanUsers.nextLine());


        //Проверяем введенные данные
        g = dataFilling(login2, password2, adminHashMap, sysAdminHashMap, usersHashMap, userLinkedList, adminLinkedList, sysAdminLinkedList);
       // printLinkedList( userLinkedList, adminLinkedList, sysAdminLinkedList);

       return g;

    }

    protected static void fillingTheCollectionItems() throws Exception {
        TreeMap<Integer, String> buffer = new TreeMap<Integer, String>();
        TreeMap<Integer, String> buffer2 = new TreeMap<Integer, String>();
        List<Object> suppliers = new ArrayList<Object>();
        List<Object> things = new ArrayList<Object>();
        List<Things> things1 = new ArrayList<Things>();

        FileReader thingsFile = new FileReader("C://Users//Admin//IdeaProjects//apllicationJava//items//items.txt");
        Scanner scanThings = new Scanner(thingsFile);

        FileReader suppliersFile = new FileReader("C://Users//Admin//IdeaProjects//apllicationJava//items//supplier.txt");
        Scanner scanSuppliers = new Scanner(suppliersFile);

        int i = 0, j = 0, count = 1, count2  = 1;

        while (scanThings.hasNextLine())
                buffer.put(++i, scanThings.nextLine());

        i = 0;
        while (scanSuppliers.hasNextLine())
            buffer2.put(++i, scanSuppliers.nextLine());

//        for (Map.Entry<Integer, String> pu : buffer2.entrySet())
//            System.out.println(pu.getKey() + "\t" + pu.getValue());


        List<String> id= new ArrayList<String>();
        List<String> product = new ArrayList<String>();
        List<Integer> quantity = new ArrayList<Integer>();
        List<Float> price = new ArrayList<Float>();
        List<Float> weight = new ArrayList<Float>();


        List<String> idS= new ArrayList<String>();
        List<String> name = new ArrayList<String>();
        List<String> adress = new ArrayList<String>();
        List<String> phone_number = new ArrayList<String>();

       System.out.println(buffer.size());
       System.out.println(buffer2.size());


        for (Map.Entry<Integer, String> y : buffer2.entrySet()) {
            switch (count2) {
                case 1:
                    suppliers.add(y.getValue());
                    break;
                case 2:
                    suppliers.add(y.getValue());
                    break;
                case 3:
                    suppliers.add(y.getValue());
                    break;
                case 4:
                    suppliers.add(y.getValue());
                    break;
                case 5:
                    count2 = 0;
                    break;
            }
            count2++;
        }

        for (Map.Entry<Integer, String> x : buffer.entrySet()) {
            switch (count) {
                case 1:
                    things.add(x.getValue());
                    break;
                case 2:
                    things.add(x.getValue());

                    break;
                case 3:
                   things.add(Integer.parseInt(x.getValue()));
                    break;
                case 4:
                   things.add(Float.parseFloat(x.getValue()));

                    break;
                case 5:
                    things.add(Float.parseFloat(x.getValue()));
                    break;
                case 6:
                    count = 0;
                    break;
            }
            count++;
        }

        String idV = "";
        String productV = "";
        int quantityV = 0;
        float priceV = 0;
        float weightV = 0;

        String nameV = "";
        String surnameV = "";
        String adressV = "";
        String phone_numberV = "";

        System.out.println("SupSize: " + suppliers.size());
        System.out.println("ThSize: " + things.size());

        Object[] thinngsArray = new Object[things.size()];
        Object[] suplArray = new Object[suppliers.size()];

        things.toArray(thinngsArray);
        suppliers.toArray(suplArray);

        int index_1 = 0;
        int index_2 = 0;
        int cnt = 1;

        Object[] sup_things = new Object[thinngsArray.length + suplArray.length];

       for (int index = 0; index <  suplArray.length; index++) {

          System.out.println(index + "\t" + suplArray[index]);

       }
        System.out.println();

       for (int index_4 = 0; index_4 < thinngsArray.length; index_4++){

          System.out.println(index_4 + "\t" + thinngsArray[index_4]);

       }


       for (int index_3 = 0; index_3 < suplArray.length; index_3++){
          sup_things[index_3] = suplArray[index_3];
       }

        System.out.println("\n\n\nNext:\n");
       for (Things thn : things1)
           System.out.println(thn.toString());


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

        //interface AccessLevel
        AccessLevel sysAdmin = new SysAdmin();
        AccessLevel user = new User();
        AccessLevel admin = new Admin();

        int userInterface = user.getAccessLevel();
        int adminInterface = admin.getAccessLevel();
        int sysAdminInterface = sysAdmin.getAccessLevel();


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
                return adminInterface;
            }
            count++;
        }



        for (Map.Entry<Integer, String> itemSysAdmin : sysAdminList.entrySet()){
            switch (count2){
                case 1:
                    name = itemSysAdmin.getValue();
                    break;
                case 2:
                    surname = itemSysAdmin.getValue();

                    break;
                case 3:
                    login1 = itemSysAdmin.getValue();
                    break;
                case 4:
                    password1 = itemSysAdmin.getValue();
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
                return sysAdminInterface;
            }
            count2++;
        }


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
                return userInterface;
            }
            count3++;
        }

return 0;
    }

}
