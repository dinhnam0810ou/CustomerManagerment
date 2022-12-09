package com.ndn.model;

public class Customer {
    private int id;
    private String name;
    private String gender;
    private String phone_number;
    private String address;
    private String email;
    private int point;
    private String membership_level;
    private int ticket_free;
    
    public Customer() {}
    public Customer(String name, String gender, String phone_number,
            String address, String email) {
        if( name.equals("") || gender.equals("") || phone_number.equals("") ) {
            System.out.println("Customer data can not empty");
        }
        else {
                this.name = name;
                this.gender = gender;
                this.phone_number = phone_number;
                this.address = address;
                this.email = email;
                this.point = 0;
        }  
    }
    
    
    public String getMembership_level() {
        if(this.point < 100) membership_level = "Silver"; 
        else if(this.point >= 100 && this.point < 250) membership_level = "Gold";
        else membership_level = "Platinum";
        return membership_level;
    }
    
    
    public int getTicket_free() {
        if(this.point < 100) ticket_free = 0; 
        else if(this.point >= 100 && this.point < 250) ticket_free = 2;
        else ticket_free = 5;
        return ticket_free;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
  
}
