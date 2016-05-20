package com.andreenko.service;

import com.andreenko.model.Deal;

import java.util.List;

/**
 * Created by jj on 16.05.2016.
 */
public interface DealService {
    void addDeal(Deal deal);
    void updateDeal(Deal deal);
    Deal getDeal(int id);
    void deleteDeal(int id);
    List<Deal> getDeals();
    void addDefaultRecord();
    List<Deal> getDoneDeals();
    List<Deal> getNotDoneDeals();
    List<Deal> getDealForId(int i);
    Integer getCount();
}
