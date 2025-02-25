package com.pisareff;

import com.pisareff.entity.Role;
import com.pisareff.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        //configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy())
        //configuration.addAnnotatedClass(User.class); // отслеживаем класс сущности
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            User user = User.builder()
                    .username("pisareff@gmail.com")
                    .firstName("Alexander")
                    .lastName("Pisareff")
                    .birthDate(LocalDate.of(1997, 1, 21))
                    .age(28)
                    .role(Role.USER)
                    .build();

            session.persist(user);
            session.getTransaction().commit();
        }


    }
}
