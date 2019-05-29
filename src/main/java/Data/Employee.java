package Data;


public class Employee {
   private int userid;
   private String name;
   private String password;
   private int phone;

    public Employee(int userid, String name, String password, int phone) {
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }
        public Employee(int userid, String password) {
        this.userid = userid;
        this.password = password;
    }
            public Employee(int userid, String name, String password) {
        this.userid = userid;
        this.name = name;
        this.password = password;
    }
    

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" + "userid=" + userid + ", name=" + name + ", password=" + password + ", phone=" + phone + '}';
    }


}