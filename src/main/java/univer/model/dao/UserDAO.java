package univer.model.dao;

import org.apache.commons.codec.digest.DigestUtils;
import univer.controller.EMF;
import univer.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {

    public User get(Integer id) {
        EntityManager em = EMF.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public User getUserByLoginAndPassword(String login, String password) {
        EntityManager em = EMF.createEntityManager();
        TypedQuery<User> query = em.
                createQuery("SELECT u FROM User u WHERE u.username= :userLogin AND u.password= :userPassword", User.class);
        query.setParameter("userLogin", login);
        query.setParameter("userPassword", DigestUtils.sha256Hex(password));
        User user = query.getSingleResult();
        em.close();
        return user;
    }

    public void saveOrUpdate(User persistent) throws DAOException {
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(persistent);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new DAOException("Can't save user into DB", e);
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) throws DAOException {
        EntityManager em = EMF.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("delete User where id= :userId");
            query.setParameter("userId", id);
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw new DAOException("Can't delete user", e);
        }
        em.close();
    }

    public List<User> getAll() {
        EntityManager em = EMF.createEntityManager();
        List<User> userList = em.createQuery("from User").getResultList();
        em.close();
        return userList;
    }
}
