package BookRestAPI.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private int uid;
    @Column(name = "first_name")
    private String fname;
    @Column(name = "last_name")
    private String lname;
    @Column(name = "user_name")
    private String username;
    private String role;
    @Column(name = "pass")
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "contect_no")
    private long contactno;

    public User(int uid, String fname, String lname, String username, String role, String password, String address,
                long contactno) {
        super();
        this.uid = uid;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.role = role;
        this.password = password;
        this.address = address;
        this.contactno = contactno;
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", contactno=" + contactno +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContactno() {
        return contactno;
    }

    public void setContactno(long contactno) {
        this.contactno = contactno;
    }

}
