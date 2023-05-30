package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarsController {

    private CarService service;

    @GetMapping("/cars")
    public String carController(ModelMap model, @RequestParam(required = false) Integer count) {
        model.addAttribute("messages", service.listSomeCars(count));
        return "cars";
    }

    @Autowired
    public void setService(CarService service) {
        this.service = service;
    }
}
