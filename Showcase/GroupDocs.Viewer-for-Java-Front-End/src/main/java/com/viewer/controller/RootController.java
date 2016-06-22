package com.viewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sampleapp")
public class RootController
{

  @RequestMapping(method=RequestMethod.GET)
  public String index()
  {
    return "index";
  }

}