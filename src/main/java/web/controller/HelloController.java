package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping("/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping("/cars")
	public String carController(ModelMap model, @RequestParam(required = false) Integer count) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("car1", 123, "color1"));
		cars.add(new Car("car2", 234, "color2"));
		cars.add(new Car("car3", 345, "color3"));
		cars.add(new Car("car4", 456, "color4"));
		cars.add(new Car("car5", 567, "color5"));
		model.addAttribute("messages", cars.stream().limit(count == null ? 5 : count).toList());
		return "cars";
	}
}