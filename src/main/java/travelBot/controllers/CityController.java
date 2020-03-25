package travelBot.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import travelBot.jpa.model.City;
import travelBot.service.CityService;

import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllCities(Model model) {
        model.addAttribute("cities", cityService.getAllCities());
        return "index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getCity(@PathVariable Long id, Model model) {
        City city = cityService.findCityById(id);
        if (Objects.isNull(city)) {
            log.error("Not found city: " + id);
        }
        model.addAttribute("city", city);
        return "city";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editCity(@PathVariable Long id,
                           @RequestParam String name,
                           @RequestParam String subName,
                           @RequestParam String description) {

        cityService.updateCity(id, name, subName, description);

        return "redirect:/cities";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String goToAddForm() {
        return "addCity";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewCity(@RequestParam String name,
                             @RequestParam String subName,
                             @RequestParam String description,
                             Model model) {

        if (Objects.nonNull(cityService.getCityByName(name)) | Objects.nonNull(cityService.getCityBySubName(subName))) {
            model.addAttribute("response", "Такой город есть в базе...");
        } else {
            cityService.saveCity(name, subName, description);
            return "redirect:/cities";
        }
        return "addCity";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return "redirect:/cities";
    }

}
