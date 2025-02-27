package com.pisareff;

import com.pisareff.demo.demoEntity.*;
import com.pisareff.entity.Birthday;
import com.pisareff.entity.PersonalInfo;
import com.pisareff.entity.Role;
import com.pisareff.entity.User;
import com.pisareff.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class HibernateDemosClass {

    public static final Logger logger = LogManager.getLogger();

    public static void demoPersist() {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            User user = User.builder()
                    .username("pisareff@gmail.com")
                    .personalInfo(PersonalInfo.builder()
                            .firstName("Alexander")
                            .lastName("Pisareff")
                            .birthDate(new Birthday(LocalDate.of(1997, 1, 21)))
                            .build())
                    .role(Role.USER)
                    .build();

            logger.info("User entity was created and is in transient state : {}", user);

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
                    .personalInfo(PersonalInfo.builder()
                            .firstName("Alexander")
                            .lastName("Pisareff")
                            .birthDate(new Birthday(LocalDate.of(1997, 1, 21)))
                            .build())
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

    public static void demoIdentityPKGen(){
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            EntityIdentityPKGen entity = EntityIdentityPKGen.builder()
                    .info("Полученный ключ сгенерирован СУБД автоматически")
                    .build();

            session.persist(entity); // Save or update
            session.getTransaction().commit();
        }
    }

    public static void demoSequencePKGen(){
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            EntitySequencePKGen entity = EntitySequencePKGen.builder()
                    .info("Полученный ключ сгенерирован Hibernate c помощью последовательности из СУБД")
                    .build();

            session.persist(entity); // Save or update
            session.getTransaction().commit();
        }
    }

    public static void demoTablePKGen(){
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            EntityTablePKGen entity = EntityTablePKGen.builder()
                    .info("Полученный ключ сгенерирован Hibernate через таблицу с ключами")
                    .build();

            session.persist(entity); // Save or update
            session.getTransaction().commit();
        }
    }

    public static void demoEmbeddedIdPersist(){
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            EntityEmbeddedId entity = EntityEmbeddedId.builder()
                    .embeddedIdentifier(EmbeddedIdentifier.builder()
                            .firstName("Alex")
                            .lastName("Pisareff")
                            .build())
                    .info("Данная сущность имеет составной ключ, реализованный через Embedded class")
                    .build();

            session.persist(entity); // Save or update
            session.getTransaction().commit();
        }
    }

    public static void demoEmbeddedIdGet(){
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            EmbeddedIdentifier key = EmbeddedIdentifier.builder()
                    .firstName("Alex")
                    .lastName("Pisareff")
                    .build();

            EntityEmbeddedId entity = session.get(EntityEmbeddedId.class, key);// Save or update
            System.out.println(entity);
            session.getTransaction().commit();
        }
    }

}
