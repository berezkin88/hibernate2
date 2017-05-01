package practice.Model;

import org.hibernate.FlushMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Alexander on 30/04/2017.
 */
@Entity
public class Waiter extends Employee {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @Fetch(FetchMode.JOIN)
    private List<Orders> orders;

    public List<Orders> getOrders() {
        return orders;
    }



    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "id=" + getId() + "\n" +
                "name='" + getName() + '\'' + "\n" +
                "surname='" + getSurname() + '\'' + "\n"+
                "telephoneNumber='" + getTelephoneNumber() + '\'' + "\n"+
                "position=" + getPosition() + "\n"+
                "salary=" + getSalary() + "\n"+
                "orders=" + orders + "\n" +
                '}' + "\n";
    }
}
