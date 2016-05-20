package com.andreenko.controller;

import com.andreenko.model.Deal;
import com.andreenko.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

/**
 * Created by jj on 16.05.2016.
 */

@Controller
@RequestMapping(value = "/deal")
public class DealController {
    @Autowired
    private DealService dealService;
    private static ModelAndView modelAndView;
    private static List<Deal> deals;


    @RequestMapping(value = "/lister/{page}")
    public ModelAndView nextPage(@PathVariable Integer page) {
        modelAndView = new ModelAndView("list-of-deals");
        PagedListHolder<Deal> pagedListHolder = new PagedListHolder<>(deals);
        pagedListHolder.setPageSize(5);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) page = 1;

        modelAndView.addObject("page", page);
        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            modelAndView.addObject("deals", pagedListHolder.getPageList());
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("deals", pagedListHolder.getPageList());
        }
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }


    @RequestMapping(value = "/all_deal")
    public ModelAndView allDeal() {
        deals = dealService.getDeals();
        return nextPage(0);
    }

    @RequestMapping(value = "/done_deal")
    public ModelAndView doneDeal() {
        deals = dealService.getDoneDeals();
        return nextPage(0);
    }

    @RequestMapping(value = "/not_done_deal")
    public ModelAndView notDoneDeal() {
        deals = dealService.getNotDoneDeals();
        return nextPage(0);
    }

    //    ========================================================================

//    ========================================================================
//    ========================================================================
//    ========================================================================
//    ========================================================================
//    ========================================================================

    @RequestMapping(value = "/test")
    public ModelAndView testSearch(@RequestParam("name") String param) {
        List<Deal> de = dealService.getDealForId(Integer.parseInt(param));
        ModelAndView model = new ModelAndView("list-of-deals");
        if(de.size() >0) {
            model.addObject("deals", de);
        }else
        {
            model = new ModelAndView("not-search");
        }
        model.addObject("param",1);
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDeal(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        dealService.deleteDeal(id);
        modelAndView.addObject("message", "Запись удалена");
        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public ModelAndView listOfDeals() {
        ModelAndView modelAndView = new ModelAndView("full-list-of-deals");
        List<Deal> d = dealService.getDeals();
        modelAndView.addObject("deals", d);
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addDealPage() {
        ModelAndView modelAndView = new ModelAndView("add-deal-form");
        modelAndView.addObject("deal", new Deal());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addingDeal(@ModelAttribute Deal deal) {
        ModelAndView modelAndView = new ModelAndView("home");
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        dealService.addDeal(deal);
        String message = "Операция проведена успешно";
        modelAndView.addObject("message", message);
        return modelAndView;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editDealPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-deal-form");
        Deal deal = dealService.getDeal(id);
        modelAndView.addObject("deal", deal);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editingDeal(@ModelAttribute Deal deal) {
        ModelAndView modelAndView = new ModelAndView("home");
        dealService.updateDeal(deal);
        String message = "Отредактированно";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/add_default_record")
    public ModelAndView addDefaulRecord() {
        dealService.addDefaultRecord();
        ModelAndView modelAndView = new ModelAndView("home");
        String message = "10 дел добавленно";
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
