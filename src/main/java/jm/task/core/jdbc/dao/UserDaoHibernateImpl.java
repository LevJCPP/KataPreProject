package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    @Override
    public void createUsersTable() {
        executeTransaction(session -> session.createSQLQuery("""
                    CREATE TABLE IF NOT EXISTS users (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(45) NOT NULL,
                        last_name VARCHAR(45) NOT NULL,
                        age TINYINT NOT NULL);""").addEntity(User.class).executeUpdate());
    }

    @Override
    public void dropUsersTable() {
        executeTransaction(session -> session.createSQLQuery("DROP TABLE IF EXISTS users")
                .addEntity(User.class).executeUpdate());
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        executeTransaction(session -> session.save(new User(name, lastName, age)));
    }

    @Override
    public void removeUserById(long id) {
        executeTransaction(session -> session.createQuery("delete from User where id = :id ")
                .setParameter("id", id).executeUpdate());
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void cleanUsersTable() {
        executeTransaction(session -> getAllUsers().forEach(session::remove));
    }

    /**
     * Utility interface for hibernate transaction body description.
     */
    @FunctionalInterface
    private interface TransactionBody {
        void executeTransaction(Session session);
    }

    /**
     * Utility method to wrap a simple hibernate transaction with common boilerplate code.
     * @param transactionBody Transaction to be executed.
     */
    private void executeTransaction(TransactionBody transactionBody) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            transactionBody.executeTransaction(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
