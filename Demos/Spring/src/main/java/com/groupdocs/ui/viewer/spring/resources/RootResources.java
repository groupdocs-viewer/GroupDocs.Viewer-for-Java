package com.groupdocs.ui.viewer.spring.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootResources {

    @RequestMapping("/")
    public ModelAndView root() {
        return new ModelAndView("redirect:/viewer");
    }
}
