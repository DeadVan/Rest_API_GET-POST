package Dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
    @JsonCreator
    public User(@JsonProperty("id") int id,
                @JsonProperty("name") String name,
                @JsonProperty("username") String username,
                @JsonProperty("email") String email,
                @JsonProperty("address") Address address,
                @JsonProperty("phone") String phone,
                @JsonProperty("website") String website,
                @JsonProperty("company") Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }
    @Override
    public String toString() {
        return id+ "\n"+name+ "\n"+username+ "\n"+email+ "\n"+getAddress().getStreet()
                                                             +getAddress().getSuite()
                                                             +getAddress().getCity()
                                                             +getAddress().getZipcode()
                                                             +getAddress().getGeo().getLat()
                                                             +getAddress().getGeo().getLng()
                +"\n"+phone+ "\n"+website+ "\n"+getCompany().getName()
                                               +getCompany().getCatchPhrase()
                                               +getCompany().getBs();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        return Objects.equals(this.toString(), other.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.username, this.email,this.phone,this.website);
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
