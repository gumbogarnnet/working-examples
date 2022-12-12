/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cadastore.lesley_gumbo.controller;

import com.cadastore.lesley_gumbo.entity.District;
import com.cadastore.lesley_gumbo.entity.User;
import com.cadastore.lesley_gumbo.service.DistrictDao;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ggumbo
 */
@RestController
public class DistrictController {

    @Autowired
    DistrictDao districtDao;

    @PostMapping("/savedistrict")
    @CrossOrigin(origins = "*")
    public String saveDistrict(@RequestBody District district) {
        districtDao.save(district);
        return "Saved Successfully";

    }

    @GetMapping("/getalldistricts")
    @CrossOrigin(origins = "*")
    public List<District> getAllUsers() {
        return districtDao.findAll();

    }

    @GetMapping("/adddistrict/{adddistrict}")
    @CrossOrigin(origins = "*")
    public void addDistrict(@PathVariable String adddistrict) {
        District district = new District();
        district.setName(adddistrict);
        districtDao.save(district);

    }

    static class DistrictDto {

        private Integer id;
        private String name;

        public DistrictDto(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

    }

}
