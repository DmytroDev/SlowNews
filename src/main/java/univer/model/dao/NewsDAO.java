package univer.model.dao;

import univer.controller.EMF;
import univer.model.entity.News;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class NewsDAO {

    public News get(Integer id) {
        EntityManager em = EMF.createEntityManager();
        News news = em.find(News.class, id);
        em.close();
        return news;
    }

    public void saveOrUpdate(News persistent) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.merge(persistent);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Integer id) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete News where id= :newsId");
        query.setParameter("newsId", id);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public List<News> getAll() {
        EntityManager em = EMF.createEntityManager();
        List<News> newsList = em.createQuery("from News").getResultList();
        em.close();
        return newsList;
    }

    public List<News> getNewsListByUserID(int id) {
        EntityManager em = EMF.createEntityManager();
        Query query = em.createQuery("SELECT n FROM News n WHERE n.user.id = :userID");
        query.setParameter("userID", id);
        List<News> newsList = query.getResultList();
        em.close();
        return newsList;
    }

}
