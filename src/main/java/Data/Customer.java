package Data;

public class Customer {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private int phone;

    public Customer(int id, String email, String password, String firstname, String lastname, String address, int phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
    }

    public Customer(String email, String password, String firstname, String lastname, String address, int phone) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
    }
    

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", phone=" + phone + '}';
    }
   

     
    }


