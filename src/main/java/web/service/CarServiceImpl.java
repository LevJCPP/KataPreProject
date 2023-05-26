package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarDao dao;

    @Override
    public void add(Car car) {
        dao.add(car);
    }

    @Override
    public List<Car> listSomeCars(Integer count) {
        return dao.listSomeCars(count);
    }

    @Autowired
    public void setDao(CarDao dao) {
        this.dao = dao;
    }
}
