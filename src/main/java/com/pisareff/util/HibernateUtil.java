package com.pisareff.util;

import com.pisareff.converter.BirthdayConverter;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@UtilityClass
public class HibernateUtil {

    private static final Configuration CONFIGURATION;

    static {
        CONFIGURATION = new Configuration();
        //configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy())
        //configuration.addAnnotatedClass(User.class); // отслеживаем класс сущности
        CONFIGURATION.addAttributeConverter(new BirthdayConverter()); // Объявляем конвертер. Поле autoApply не обязательно если в классе конвертера есть аннотация
        CONFIGURATION.configure();
    }

    public static SessionFactory getSessionFactory(){
        return CONFIGURATION.buildSessionFactory();
    }

}
