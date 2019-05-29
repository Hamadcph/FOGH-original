package Data;

public class Request {
    private int id;
    private Carport carport;
    private Customer customer;
    private ShippingAddress address;
    private MaterialList list;

    /**
     *
     * @param id
     * @param carport
     * @param customer
     * @param address
     * @param list
     */
    public Request(int id, Customer customer, Carport carport, ShippingAddress address, MaterialList list) {
        this.id = id;
        this.customer = customer;
        this.carport = carport;
        this.address = address; 
        this.list = list;
    }

    public Request(Carport carport, Customer customer) {
        this.carport = carport;
        this.customer = customer;
    }

    public Request(Carport carport, Customer customer, ShippingAddress address, MaterialList list) {
        this.carport = carport;
        this.customer = customer;
        this.address = address;
        this.list = list;
    }
    

    public Carport getCarport() {
        return carport;
    }

    public MaterialList getList() {
        return list;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getId() {
        return id;
    }

    public ShippingAddress getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Request{" + "id=" + id + ", carport=" + carport + ", customer=" + customer + ", address=" + address + ", list=" + list + '}';
    }
    
    
}
