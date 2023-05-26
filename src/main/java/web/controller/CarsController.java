package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarsController {

    private CarService service;

    @GetMapping("/cars")
    public String carController(ModelMap model, @RequestParam(required = false) Integer count) {
        service.add(new Car("car1", 123, "color1"));
        service.add(new Car("car2", 234, "color2"));
        service.add(new Car("car3", 345, "color3"));
        service.add(new Car("car4", 456, "color4"));
        service.add(new Car("car5", 567, "color5"));

        List<Car> cars = service.listSomeCars(count);
        model.addAttribute("messages", cars);
        return "cars";
    }

    @Autowired
    public void setService(CarService service) {
        this.service = service;
    }
}
