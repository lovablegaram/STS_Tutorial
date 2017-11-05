package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
	
	@Autowired
	private HelloDao helloDao;

//    @RequestMapping("/greeting")
//    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//    @RequestMapping("/hello")
//    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "hello";
//    }
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("helloData", new HelloData());
        return "greeting";
    }
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute HelloData helloData) {
    		helloDao.save(helloData);
        return "greeting";
    }
    @ResponseBody
    @RequestMapping("/send")
    public HelloData sendData(){
    		return new HelloData(1243, "test");
    }
    
    @ResponseBody
    @RequestMapping("/list")
    public List<HelloData> showDatas(){
    		return helloDao.findAll();
    }
    
       
}
