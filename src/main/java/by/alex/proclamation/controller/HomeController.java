package by.alex.proclamation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {


    @RequestMapping(value = "/home")
    public ModelAndView home() {
        log.info("Старт приложения");
        return new ModelAndView("index");
    }

}
