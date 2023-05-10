package isp.lab6.exercise3;

public class User {
    private String username;
    private String password;
    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if(obj instanceof User){
            User u = (User) obj;
            return u.username.equals(this.username);
        }
        else return false;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int result=1;
        if(this.username!=null)
            for(int i=0;i<this.username.length();i++)
                result+=(int)this.username.charAt(i);
        return result;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
