package org.shiroboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@RequestMapping(value = "/a")
    public ModelAndView a(@RequestParam String name) {
    	ModelAndView view=new ModelAndView("message");
    	view.addObject("message",name);
        return view;
    }
	
	@RequestMapping(value = "/b/{name}")
    public ModelAndView b(@PathVariable String name) {
    	ModelAndView view=new ModelAndView("message");
    	view.addObject("message",name);
        return view;
    }
	
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ModelAndView getIndex(Model model) {
    	Map<String,Object> params=model.asMap();
    	ModelAndView view=new ModelAndView("index");
    	view.addObject("message","I'm shiroboot");
        return view;
    }
    
    
    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    public ModelAndView listUser(Model model) {
    	ModelAndView view=new ModelAndView("listUser");
    	
    	List<Map<String,String>> userList = new ArrayList<Map<String,String>>();
        for (int i = 0; i <10; i++) {
        	Map<String,String> m=new HashMap<String,String>();
        	m.put("id",i+ "");
        	m.put("name","name"+i);
            userList.add(m);
        }
        
        model.addAttribute("users", userList);
    	return view;
    }
    
    
}
