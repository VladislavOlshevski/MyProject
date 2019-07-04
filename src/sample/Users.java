package sample;

public class Users {
    private String userName;
    private  String userPass;

    public Users(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public Users() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }


}
