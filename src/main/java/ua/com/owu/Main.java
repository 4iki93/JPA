package ua.com.owu;

import ua.com.owu.entity.Room;
import ua.com.owu.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("okten");
        EntityManager manager = factory.createEntityManager();


        manager.getTransaction().begin();
        //manager.persist(new User("vasya","pupkin"));
        //System.out.println(manager.find(User.class, 1));


        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room (13));
        rooms.add(new Room (41));
        rooms.add(new Room (15));
        User user = manager.find(User.class, 1);
        user.setRooms(rooms);
        manager.persist(user);
        manager.getTransaction().commit();


        manager.close();
        factory.close();
    }
}
