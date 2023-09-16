package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//          1
            Person person = session.get(Person.class, 1);  // get person with id = 1

            System.out.println(person.getName());
            System.out.println(person.getAge());
//          2
//            Person person1 = new Person("Test1", 20);
//            Person person2 = new Person("Test2", 30);
//            Person person3 = new Person("Test3", 40);
//
//            session.persist(person1); // save these three people
//            session.persist(person2);
//            session.persist(person3);
//          3
//            Person person = session.get(Person.class, 2);
//            person.setName("new name");

//            session.remove(person);

//            Person person = new Person("some name", 60);
//            session.persist(person);
//            System.out.println(person.getId());
//          4
//            List<Person> people = session.createQuery("update Person set name='Test' where age <30")
//                    .getResultList();
//
//            for (Person person: people) {
//                System.out.println(person);
//            }

//            session.createQuery("delete from Person  where age <30")
//                    .executeUpdate();

            session.getTransaction().commit();
        }
    }
}
