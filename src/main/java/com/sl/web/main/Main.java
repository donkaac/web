package com.sl.web.main;

import com.sl.web.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Achi on 4/14/2020.
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List list = session.createQuery("from Menu").list();
        System.out.println(list);
    }
}
