package com.andreenko.dao;

import com.andreenko.model.Deal;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jj on 16.05.2016.
 */
@Repository
public class DealDAOImpl implements DealDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addDeal(Deal deal) {
        getCurrentSession().save(deal);
    }

    @Override
    public void updateDeal(Deal deal) {
        Deal dealToUpdate = getDeal(deal.getId());
        dealToUpdate.setDone(deal.getDone());
        dealToUpdate.setBusiness(deal.getBusiness());
        getCurrentSession().update(dealToUpdate);
    }

    @Override
    public Deal getDeal(int id) {
        return (Deal) getCurrentSession().get(Deal.class, id);
    }

    @Override
    public void deleteDeal(int id) {
        Deal deal = getDeal(id);
        if (deal != null)
            getCurrentSession().delete(deal);
    }

    @SuppressWarnings("unchecked")
    public List<Deal> getDeals() {
        return getCurrentSession().createQuery("from Deal").list();
    }

    @Override
    public void addDefaultRecord() {
        Deal deal = new Deal();
        deal.setBusiness("b1");
        deal.setDone(false);
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        getCurrentSession().save(deal);
        deal = new Deal();
        deal.setBusiness("b2");
        deal.setDone(false);
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        getCurrentSession().save(deal);
        deal = new Deal();
        deal.setBusiness("b3");
        deal.setDone(false);
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        getCurrentSession().save(deal);
        deal = new Deal();
        deal.setBusiness("b4");
        deal.setDone(false);
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        getCurrentSession().save(deal);
        deal = new Deal();
        deal.setBusiness("b5");
        deal.setDone(false);
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        getCurrentSession().save(deal);
        deal = new Deal();
        deal.setBusiness("b6");
        deal.setDone(true);
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        getCurrentSession().save(deal);
        deal = new Deal();
        deal.setBusiness("b7");
        deal.setDone(true);
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        getCurrentSession().save(deal);
        deal = new Deal();
        deal.setBusiness("b8");
        deal.setDone(true);
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        getCurrentSession().save(deal);
        deal = new Deal();
        deal.setBusiness("b9");
        deal.setDone(true);
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        getCurrentSession().save(deal);
        deal = new Deal();
        deal.setBusiness("b10");
        deal.setDone(true);
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        getCurrentSession().save(deal);
    }

    @Override
    public List<Deal> getDoneDeals(int page) {
        Query query = this.getCurrentSession().createQuery("FROM Deal where done='1'");
        query.setFirstResult(page);
        query.setMaxResults(5);
        return query.list();
    }
    @Override
    public List<Deal> getNotDoneDeals(int page) {
        Query query = this.getCurrentSession().createQuery("FROM Deal where done='0'");
        query.setFirstResult(page);
        query.setMaxResults(5);
        return query.list();
    }


    @Override
    public List<Deal> getDealForId(int i) {
        return  getCurrentSession().createQuery("from Deal where id='"+i+"'").list();
    }

    @Override
    public Integer getCount() {
        Long l = (Long) getCurrentSession().createCriteria(Deal.class).setProjection(Projections.rowCount()).uniqueResult();
        Integer i = new Integer(String.valueOf(l));
        return i;
    }

    @Override
    public List<Deal> getDeals(int page) {
        Query query = this.getCurrentSession().createQuery("FROM Deal");
        query.setFirstResult(page);
        query.setMaxResults(5);
        return query.list();
    }

    @Override
    public int getNotCount() {
        return getCurrentSession().createQuery("from Deal where done='0'").list().size();
    }

    @Override
    public int getDoneCount() {
        return  getCurrentSession().createQuery("from Deal where done='1'").list().size();
    }
}
