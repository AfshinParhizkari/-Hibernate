package com.afshin.Entity;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 12 - 23
 * @Time 11:26 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
import com.fasterxml.jackson.annotation.JsonFilter;
import javax.persistence.*;

@Entity
@Table(name = "users")
@JsonFilter("UserFilter")
public class User {
    public User() {}

    @Id
    @Column(name = "id")
    private Integer idusers;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "employeefk")
    private Integer employeeid;

    @ManyToOne
    @JoinColumn(name = "employeefk",referencedColumnName = "employeeNumber",insertable = false,updatable = false)
    private Employee employee;

    public Integer getIdusers() {return idusers;}
    public void setIdusers(Integer idusers) {this.idusers = idusers;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Integer getEmployeeid() {return employeeid;}
    public void setEmployeeid(Integer employeeid) {this.employeeid = employeeid;}
    public Employee getEmployee() {return employee;}

    @Override
    public String toString() {
        return "User{" +
                "idusers=" + idusers +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeid=" + employeeid +
                //", employee=" + employee +
                '}';
    }
}