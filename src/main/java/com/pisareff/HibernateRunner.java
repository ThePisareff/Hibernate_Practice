package com.pisareff;

import com.pisareff.entity.Birthday;
import com.pisareff.entity.Role;
import com.pisareff.entity.User;
import com.pisareff.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) {

        HibernateDemosClass.demoPersist();
        HibernateDemosClass.demoDelete();

    }

}
