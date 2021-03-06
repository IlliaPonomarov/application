package sample;


abstract class Human {
    private String name;
    private String surname;
    private String login;
    private String password;

    public Human() {
    }

    public Human(String name, String surname, String login, String password) {
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
}



interface AccessLevel {
    public byte getAccessLevel();
}


class User extends Human implements AccessLevel {

    public User() {
    }
    private final byte accessLevel = 3;

    public User(String name, String surname, String login, String password) {
        super(name, surname, login, password);

    }
    public byte getAccessLevel() {
        return accessLevel;
    }

}


class Admin extends Human implements AccessLevel{

    private final byte accessLevel = 2;

    public Admin() {
    }

    public Admin(String name, String surname, String login, String password) {
        super(name, surname, login, password);

    }
    public byte getAccessLevel() {
        return accessLevel;
    }

}


class SysAdmin extends Human implements AccessLevel{

    public SysAdmin(){}

    private final byte accessLevel = 1;

    public SysAdmin(String name, String surname, String login, String password) {
        super(name, surname, login, password);

    }

    public byte getAccessLevel() {
        return accessLevel;
    }


}