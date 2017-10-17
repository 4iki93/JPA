package ua.com.owu.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "users")
    private List<Room> rooms = new ArrayList<>();

    public User() {
    }


    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname, List<Room> rooms) {
        this.name = name;
        this.surname = surname;
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
