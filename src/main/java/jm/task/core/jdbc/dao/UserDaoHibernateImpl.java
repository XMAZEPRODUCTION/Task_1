package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            session.createSQLQuery("""
                    create table if not exists users(
                    id serial,
                    firstname varchar(100) not NULL,
                    lastname varchar(100) not NULL,
                    age int not NULL);
                    """).executeUpdate();
            session.getTransaction().commit();


        } catch (Exception e) {
            System.out.println("Не удалось создать таблицу");
        }

    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            session.createSQLQuery("""
                    Drop Table users
                    """).executeUpdate();
            session.getTransaction().commit();


        } catch (Exception e) {
            System.out.println("Не удалось удалить таблицу");
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            session.save(new User(name,lastName,age));
            session.getTransaction().commit();


        } catch (Exception e) {
            System.out.println("Не удалось добавить User");
        }

    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            session.delete(session.get(User.class,id));
            session.getTransaction().commit();


        } catch (Exception e) {
            System.out.println("Не удалось удалить User");
        }

    }

    @Override
    public List<User> getAllUsers() {
        List <User> list = new ArrayList<>();
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("""
                    select z from User z
                    """);
            list = query.getResultList();
            session.getTransaction().commit();


        } catch (Exception e) {
            System.out.println("Не удалось достать User");
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            session.createSQLQuery("""
                    TRUNCATE TABLE users
                    """).executeUpdate();
            session.getTransaction().commit();


        } catch (Exception e) {
            System.out.println("Не удалось создать таблицу");
        }



    }
}
