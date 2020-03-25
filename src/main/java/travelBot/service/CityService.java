package travelBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travelBot.jpa.model.City;
import travelBot.jpa.CityRepository;

import java.util.List;
import java.util.Objects;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;


    public List<City> getAllCities() {
        return repository.findAll();
    }

    public City findCityById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public City getCityBySubName(String text) {
        return repository.findCityBySubName(text);
    }

    public City getCityByName(String text) {
        return repository.findCityByName(text);
    }

    public void updateCity(Long id, String name, String subName, String description) {
        City city = repository.getOne(id);
        if (Objects.isNull(repository.findCityByName(name))) {
            city.setName(name);
        }
        if (Objects.isNull(repository.findCityBySubName(subName))) {
            city.setSubName(subName);
        }
        city.setDescription(description);
        repository.save(city);
    }

    public void deleteCity(Long id) {
        repository.deleteById(id);
    }

//    public boolean existCityById(Long id) {
//        return repository.existsById(id);
//    }

    public void saveCity(String name, String subName, String description) {
        City city = new City();
        city.setName(name);
        city.setSubName(subName);
        city.setDescription(description);
        repository.save(city);
    }

}
