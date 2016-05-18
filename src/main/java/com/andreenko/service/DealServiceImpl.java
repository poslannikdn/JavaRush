package com.andreenko.service;

import com.andreenko.dao.DealDAO;
import com.andreenko.model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jj on 16.05.2016.
 */
@Service
@Transactional
public class DealServiceImpl implements DealService {

    @Autowired
    private DealDAO dealDAO;

    @Override
    public void addDeal(Deal deal) {
        dealDAO.addDeal(deal);
    }

    @Override
    public void updateDeal(Deal deal) {
dealDAO.updateDeal(deal);
    }

    @Override
    public Deal getDeal(int id) {
        return dealDAO.getDeal(id);
    }

    @Override
    public void deleteDeal(int id) {
        dealDAO.deleteDeal(id);
    }

    @Override
    public List<Deal> getDeals() {
        return dealDAO.getDeals();
    }

    @Override
    public void addDefaultRecord() {
        dealDAO.addDefaultRecord();
    }

    @Override
    public List<Deal> getDoneDeals() {
        return dealDAO.getDoneDeals();
    }

    @Override
    public List<Deal> getNotDoneDeals() {
        return dealDAO.getNotDoneDeals();
    }

    @Override
    public List<Deal> getDealForId(int i) {
        return dealDAO.getDealForId(i);
    }
}
