package exceptions.ue.msg;

import java.util.Objects;

public class User {

    public static String STATUS_ONLINE = "online";
    public static String STATUS_OFFLINE = "offline";

    private String name;
    private String status;
    private boolean isAdmin;

    public User(String name, String status, boolean isAdmin) {
        this.name = name;
        if(!status.equals(STATUS_ONLINE) && !status.equals(STATUS_OFFLINE)) {
            throw new IllegalArgumentException("error: status "+status+ " is invalid");
        }
        this.status = status;
        this.isAdmin = isAdmin;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
