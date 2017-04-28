package practice.Model;

import javax.persistence.*;

/**
 * Created by Alexander on 26/04/2017.
 */

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @Column(name = "salary")
    private Float salary;
}
