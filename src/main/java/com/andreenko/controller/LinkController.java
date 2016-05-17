package com.andreenko.controller;

import com.andreenko.model.Deal;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jj on 16.05.2016.
 */
@Controller
public class LinkController {


    @RequestMapping(value = "/")
    public ModelAndView mainPage(){
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/index")
    public ModelAndView indexPage(){
        return new ModelAndView("home");
    }
}
