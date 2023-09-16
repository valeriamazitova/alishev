package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//          1
//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
//
//            List<Item> items = person.getItems();
//
//            System.out.println(items);
//          2
//            Item item = session.get(Item.class, 5);
//            System.out.println(item);
//
//            Person person = item.getOwner();
//            System.out.println(person);
//
//          3
//            Person person = session.get(Person.class, 2);
//
//            Item newItem = new Item("item from hibernate", person);
//
//            person.getItems().add(newItem);
//
//            session.persist(newItem);
//          4
//            Person person = new Person("test person", 30);
//
//            Item newItem = new Item("item from hibernate2", person);
//
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
//
//            session.persist(person);
//            session.persist(newItem);
//          5
//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//
////            sql
//            for (Item item: items) {
//                session.remove(item);
//            }
//
////          не порождает sql, но необходимо, чтобы в кэше всё было верно
//            person.getItems().clear();
//          6

//            Person person = session.get(Person.class, 2);
//
//            session.remove(person);
//
//            person.getItems().forEach(i -> i.setOwner(null));
//          7
            Person person = session.get(Person.class, 4);

            Item item = session.get(Item.class, 1);
            item.getOwner().getItems().remove(item);

            item.setOwner(person);
            person.getItems().add(item);

            session.getTransaction().commit();
        }
    }
}
