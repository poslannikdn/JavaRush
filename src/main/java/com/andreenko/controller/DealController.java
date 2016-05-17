package com.andreenko.controller;

import com.andreenko.model.Deal;
import com.andreenko.service.DealService;
import org.dom4j.rule.Mode;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

/**
 * Created by jj on 16.05.2016.
 */

@Controller
@RequestMapping(value="/deal")
public class DealController {
    @Autowired
    private DealService dealService;
    @RequestMapping(value = "/all_deal")
    public ModelAndView allDeal(){
        ModelAndView modelAndView = new ModelAndView("list-of-deals");
        List<Deal> deals = dealService.getDeals();
        modelAndView.addObject("deals", deals);
        return modelAndView;
    }
    @RequestMapping(value = "/done_deal")
    public ModelAndView doneDeal(){
        ModelAndView modelAndView = new ModelAndView("list-of-deals");
        List<Deal> deals = dealService.getDoneDeals();
        modelAndView.addObject("deals", deals);
        return modelAndView;
    }
    @RequestMapping(value = "/not_done_deal")
    public ModelAndView notDoneDeal(){
        ModelAndView modelAndView = new ModelAndView("list-of-deals");
        List<Deal> deals = dealService.getNotDoneDeals();
        modelAndView.addObject("deals", deals);
        return modelAndView;
    }

    @RequestMapping(value = "/add_default_record")
    public ModelAndView addDefaulRecord(){
        dealService.addDefaultRecord();
        ModelAndView modelAndView = new ModelAndView("home");
        String message = "10 дел добавленно";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addDealPage(){
        ModelAndView modelAndView = new ModelAndView("add-deal-form");
        modelAndView.addObject("deal", new Deal());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addingDeal(@ModelAttribute Deal deal){
        ModelAndView modelAndView = new ModelAndView("home");
        deal.setAdd_date(new Date(new java.util.Date().getTime()));
        dealService.addDeal(deal);
        String message = "Операция проведена успешно";
        modelAndView.addObject("message", message);
        return modelAndView;
    }



    @RequestMapping(value = "/list")
    public ModelAndView listOfDeals(){
        ModelAndView modelAndView = new ModelAndView("list-of-deals");
        List<Deal> deals = dealService.getDeals();
        modelAndView.addObject("deals", deals);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editDealPage(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("edit-deal-form");
        Deal deal = dealService.getDeal(id);
        modelAndView.addObject("deal", deal);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editingDeal(@ModelAttribute Deal deal){
        ModelAndView modelAndView = new ModelAndView("home");
        dealService.updateDeal(deal);
        String message = "Отредактированно";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("list-of-deals");
        dealService.deleteDeal(id);
        List<Deal> deals = dealService.getDeals();
        modelAndView.addObject("deals", deals);
        return modelAndView;
    }
}
