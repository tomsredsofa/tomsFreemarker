package de.doubleslash.coffee.controller;

import de.doubleslash.coffee.service.BecherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 */
@Controller
@RequestMapping("/kaffeemacher")
public class KaffeeMacherStart {

    @Autowired
    private BecherService becherService;

    @RequestMapping("/start")
    public String kaffeeMacherStart() {
        return "KaffeeMacherStart";
    }

    @RequestMapping("/BecherPool")
    public ModelAndView showBecherPool() {
        Map<String, Object> model = new HashMap<>();
        model.put("becherPool", becherService.getBecherPool());
        ModelAndView modelAndView = new ModelAndView("BecherPool", model);
        becherService.printBecherPool();

        return modelAndView;
    }
}
