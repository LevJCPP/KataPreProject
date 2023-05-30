package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("car1", 123, "color1"));
        cars.add(new Car("car2", 234, "color2"));
        cars.add(new Car("car3", 345, "color3"));
        cars.add(new Car("car4", 456, "color4"));
        cars.add(new Car("car5", 567, "color5"));
    }

    @Override
    public List<Car> listSomeCars(Integer count) {
        return cars.stream().limit(count != null ? count : 5).toList();
    }
}
