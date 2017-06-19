package com.rent.controller;

import com.rent.form.BikeForm;
import com.rent.mapper.form.BikeFormMapper;
import com.rent.persistence.model.Bike;
import com.rent.service.bike.BikeService;
import com.rent.validation.BikeFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by dotocan on 3.6.2017..
 */

@Controller
public class BikesController {

    @Autowired
    BikeService bikeService;

    @Autowired
    BikeFormMapper bikeFormMapper;

    @Autowired
    BikeFormValidator bikeFormValidator;

    @GetMapping("/bikes")
    public String openBikesList(Model model) {
        model.addAttribute("bikes", bikeService.listAllBikes());
        return "bikes";
    }

    @GetMapping("/add-bike")
    public String openAddBike(Model model) {
        BikeForm bikeForm = new BikeForm();
        model.addAttribute("bikeForm", bikeForm);
        return "add_bike";
    }

    @PostMapping
    public ModelAndView saveBike(@ModelAttribute("bikeForm") @Valid BikeForm bikeForm, BindingResult bindingResult) {

        bikeFormValidator.validate(bikeForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("add_bike");
        } else {
            Bike newBike = bikeFormMapper.mapToEntity(bikeForm);
            bikeService.save(newBike);
            return new ModelAndView("redirect:/bikes");
        }
    }

}
