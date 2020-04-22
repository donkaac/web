/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sl.web.util;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

/**
 * @author Achi
 */
public class DataController {

    private static DataController dc;
    private static Session session;
    private static Class entity;

    public static DataController getInstance() {
        if (dc == null) {
            dc = new DataController();
        }
        return dc;
    }

    public DataController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public DataController(Class entity) {
        DataController.entity = entity;
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void setClass(Class c) {
        entity = c;
    }

    public static void removeInstance() {
        if (dc != null) {
            dc = null;
        }
    }

    public Object getById(int id) {
        try {
            Transaction tx = session.beginTransaction();
            Object load = session.load(entity, id);
            Hibernate.initialize(load);
            tx.commit();
            return load;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends Object> T getById(Class<T> type, int id) {
        try {
            Object load = session.load(type, id);
            //Hibernate.initialize(load);
            return (T) load;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List getByEq(String key, Object value) {
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery createQuery = cb.createQuery(entity);
            Root from = createQuery.from(entity);
            createQuery.select(from).
                    where(cb.equal(from.get(key), value));
            List list = session.createQuery(createQuery).getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends Object> List<T> getByEq(Class<T> type, Predicate... predicates) {
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(type);
            Root<T> root = query.from(type);
            query.select(root).where(predicates);
            List<T> list = session.createQuery(query).getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends Object> List<T> getAll(Class<T> type) {
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(type);
            Root<T> root = query.from(type);
            query.select(root);

            List<T> list = session.createQuery(query).getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean save(Object s) {
        try {
            Transaction tx = session.getTransaction();
            tx.begin();
            session.save(s);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Object s) {
        try {
            Transaction tx = session.getTransaction();
            tx.begin();
            session.merge(s);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Delete(int id) {
        try {
            Transaction tx = session.getTransaction();
            tx.begin();
            Object load = session.load(entity, id);
            session.delete(load);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List Search(String sql) {
        try {
            Query query = session.createQuery(sql);
            return query.list();
        } catch (Exception e) {
            return null;
        }
    }

    public Object SearchUnic(Class table, String colume, String val) {
        try {
            session.clear();
            Transaction tx = session.getTransaction();
            tx.begin();
            String sql = "FROM " + table.getSimpleName() + " " + table.getSimpleName().charAt(0) + " WHERE " + table.getSimpleName().charAt(0) + "." + colume + "='" + val + "'";
            Query query = session.createQuery(sql);
            tx.commit();
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List SearchBy(String table, String colume, String val) {
        try {
            session.clear();
            Transaction tx = session.getTransaction();
            tx.begin();
            String sql = "FROM " + table + " " + table.charAt(0) + " WHERE " + table.charAt(0) + "." + colume + "='" + val + "'";
            System.out.println(sql);
            Query query = session.createQuery(sql);
            tx.commit();
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends Object> List<T> Search(Class<T> type, String sql) {
        try {
            Query query = session.createQuery(sql, type);
            return query.list();
        } catch (Exception e) {
            return null;
        }
    }

    public Integer getLastIndex(Class type) {
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
            Root root = query.from(type);
            query.select(builder.max(root.get("id")));

            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
