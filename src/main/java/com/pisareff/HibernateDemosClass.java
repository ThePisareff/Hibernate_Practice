package com.pisareff;

import com.pisareff.entity.Birthday;
import com.pisareff.entity.Role;
import com.pisareff.entity.User;
import com.pisareff.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class HibernateDemosClass {

    public static void demoPersist() {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            User user = User.builder()
                    .username("pisareff@gmail.com")
                    .firstName("Alexander")
                    .lastName("Pisareff")
                    .birthDate(new Birthday(LocalDate.of(1997, 1, 21)))
                    .role(Role.USER)
                    .build();

            session.merge(user); // Save or update
            session.getTransaction().commit();
        }
    }

    public static void demoGet() {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            User user = session.get(User.class, "pisareff@gmail.com");
            System.out.println(user);

            session.getTransaction().commit();
        }
    }

    public static void demoDelete() {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            User user = User.builder()
                    .username("pisareff@gmail.com")
                    .firstName("Alexander")
                    .lastName("Pisareff")
                    .birthDate(new Birthday(LocalDate.of(1997, 1, 21)))
                    .role(Role.USER)
                    .build();

            System.out.println(user);
            session.remove(user); // delete

            session.getTransaction().commit();
        }


    }

    public static void demoGetAndDelete() {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            User user = session.get(User.class, "pisareff@gmail.com");
            System.out.println(user);

            session.remove(user);

            session.getTransaction().commit();
        }
    }

}
