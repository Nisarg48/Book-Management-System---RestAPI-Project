package BookRestAPI.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    private int sid;

    @Column(name = "first_name")
    private String fname;

    @Column(name = "last_name")
    private String lname;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_no", length = 10)
    private long contactno;

    public Supplier() {
        super();
    }

    public Supplier(int sid, String fname, String lname, String address, long contactno) {
        super();
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.contactno = contactno;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    @Override
    public String toString() {
        return "Supplier [sid=" + sid + ", fname=" + fname + ", lname=" + lname + ", address=" + address
                + ", contactno=" + contactno + "]";
    }
}
