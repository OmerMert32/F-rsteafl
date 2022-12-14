package dat3.cars.entity;

import dat3.security.entity.UserWithRoles;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Member extends UserWithRoles {

    String firstName;
    String lastName;
    String street;
    String city;
    int zip;
    boolean approved;
    int ranking;

    public Member(String user, String password, String email, String firstName, String lastName, String street, String city, int zip, boolean approved, int ranking) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.approved = approved;
        this.ranking = ranking;
    }

    public Member() {
    }
}
