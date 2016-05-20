package com.andreenko.dao;

import com.andreenko.model.Deal;

import java.util.List;

/**
 * Created by jj on 16.05.2016.
 */
public interface DealDAO {
    void addDeal(Deal deal);
    void updateDeal(Deal deal);
    Deal getDeal(int id);
    void deleteDeal(int id);
    List<Deal> getDeals();
    List<Deal> getDeals(int page);
    void addDefaultRecord();
    List<Deal> getDoneDeals(int page);
    List<Deal> getNotDoneDeals(int page);
    List<Deal> getDealForId(int i);
    Integer getCount();

    int getNotCount();
    int getDoneCount();
}
