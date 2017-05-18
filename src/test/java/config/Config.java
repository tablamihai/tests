package config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Config {

    private String name;
    private int age;



    private String phone;
    private Map<String, String> address;
    private String[] roles;
    private String partnumber;
    private String email;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Map<String, String> getAddress() {
        return address;
    }
    public void setAddress(Map<String, String> address) {
        this.address = address;
    }
    public String[] getRoles() {
        return roles;
    }
    public void setRoles(String[] roles) {
        this.roles = roles;
    }
    public String getPartnumber(){ return partnumber; }
    public void setPartnumber(String partnumber){
        this.partnumber = partnumber;
    }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
