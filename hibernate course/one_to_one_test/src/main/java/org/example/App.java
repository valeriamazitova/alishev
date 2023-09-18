package org.example;

import com.sun.source.tree.Scope;
import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            С помощью Hibernate получите любого директора, а затем получите его школу.
            Principal principal = session.get(Principal.class, 1);
            System.out.println(principal);
            System.out.println(principal.getSchool());

//            Получите любую школу, а затем получите ее директора.
            School school = session.get(School.class, 1);
            System.out.println(school);
            System.out.println(school.getPrincipal());

//            Создайте нового директора и новую школу и свяжите эти сущности.
//            Principal principal1 = new Principal("new principal", 29);
//            School school1 = new School(42);
//            principal1.setSchool(school1);
//
//            session.persist(principal1);

//            Смените директора у существующей школы.
//            School school2 = session.get(School.class, 1);
//            Principal principal2 = new Principal("new principal2", 25);
//            principal2.setSchool(school2);
//
//            session.persist(principal2);

//            Попробуйте добавить вторую школу для существующего директора
//            и изучите возникающую ошибку.
//            Principal principal3 = session.get(Principal.class, 2);
//            School school3 = new School(69);
//            principal3.setSchool(school3);
//
//            session.persist(school3);
//            ERROR: duplicate key value violates unique constraint "school_principal_id_key"

            session.getTransaction().commit();
        }
    }
}
