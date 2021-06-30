package sample;


public class User {

    private String name;
    private String surname;
    private String login;
    private String password;


    private byte accessLevel = 3;

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(byte accessLevel) {
        this.accessLevel = accessLevel;
    }
}





class Admin extends User{

    private byte accessLevel = 2;

    public Admin(String name, String surname, String login, String password) {
        super(name, surname, login, password);

    }

    @Override
    public byte getAccessLevel() {
        return accessLevel;
    }

    @Override
    public void setAccessLevel(byte accessLevel) {
        this.accessLevel = accessLevel;
    }
}


class SysAdmin extends User{

    private byte accessLevel = 1;

    public SysAdmin(String name, String surname, String login, String password) {
        super(name, surname, login, password);

    }

    @Override
    public byte getAccessLevel() {
        return accessLevel;
    }

    @Override
    public void setAccessLevel(byte accessLevel) {
        this.accessLevel = accessLevel;
    }
}