package zansfer;

public class Contact {
    private int id;
    private String name;
    private String phone;
    private String mobile;
    private String email;
    private String address;
    private String favourite;
    private String groupName;

    public Contact(String name, String phone, String mobile, String email, String address, String favourite, String groupName, String GroupColm) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.favourite = favourite;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getFavourite() {
        return favourite;
    }


    public String getGroupName() {
        return groupName;
    }
}
