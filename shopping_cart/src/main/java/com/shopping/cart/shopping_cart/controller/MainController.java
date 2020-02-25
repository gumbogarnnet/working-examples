/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopping.cart.shopping_cart.controller;

import com.shopping.cart.shopping_cart.dto.CustomerChartDto;
import com.shopping.cart.shopping_cart.model.Product;

import com.shopping.cart.shopping_cart.dto.OrdersDto;
import com.shopping.cart.shopping_cart.dto.ShoppingCartDto;
import com.shopping.cart.shopping_cart.model.OrderLine;
import com.shopping.cart.shopping_cart.model.User;
import com.shopping.cart.shopping_cart.repository.ItemRepository;
import com.shopping.cart.shopping_cart.repository.OrderRepository;

import com.shopping.cart.shopping_cart.repository.UsersRepository;
import com.shopping.cart.shopping_cart.service.ItemService;
import com.shopping.cart.shopping_cart.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author garnnet
 */
@Slf4j
@Controller
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemService itemService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/addproduct")
    public void uploadFile(MultipartFile file, @RequestParam String cartegory, @RequestParam String name, @RequestParam double price, @RequestParam String description) throws IOException {
        Product item = new Product();

        item.setImage(file.getBytes());
        item.setCartegory(cartegory);
        item.setDescription(description);
        item.setName(name);
        item.setPrice(price);

        itemRepository.save(item);

    }

    @RequestMapping("/adminhome")
    public String adminHome() {
        return "additem";
    }

    @RequestMapping("/")
    public String mainHome() {
        return "index";
    }

    @RequestMapping("/category")
    public String categorymen() {
        return "category";
    }

    @RequestMapping("/product")
    public String product() {
        return "product";
    }

    @RequestMapping("/cart")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public Optional<Product> productInfo(@PathVariable int id) {
        return itemRepository.findById(id);

    }

    @GetMapping("/getLatestProducts")
    @ResponseBody
    public List<Product> getLatestProducts() {
        return itemService.getLatestProducts();
    }

    @GetMapping("/getProducts/{cartegory}")
    @ResponseBody
    public List<Product> getMenProducts(@PathVariable String cartegory) {
//        return itemService.getProducts(cartegory);
return itemRepository.findAll();
    }

    @GetMapping("getAllProducts")
    @ResponseBody
    public List<Product> getAllProducts() {
        return itemRepository.findAll();
    }

        @GetMapping("getTotalsales")
    @ResponseBody
    public List<Integer> getTotalsales() {
        List<Date> dates = new ArrayList<>();
        ArrayList<Integer> keyList = new ArrayList<>();
        ArrayList<Integer> valueList = new ArrayList<>();
        List<Integer> dates1 = new ArrayList<>();
        ArrayList dates2 = new ArrayList<>();
        List<OrderLine> orders = orderRepository.findAll();
        for (OrderLine orderLine : orders) {
            Date date = orderLine.getDate(); // the date instance
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            dates1.add(calendar.get(Calendar.MONTH) + 1);

        }

        CustomerChartDto customerChartDtoItem = new CustomerChartDto();
        List<CustomerChartDto> customerChartDto = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer s : dates1) {
            Integer count = frequencyMap.get(s);
            if (count == null) {
                count = 0;
            }

            frequencyMap.put(s, count + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            keyList = new ArrayList<Integer>(frequencyMap.keySet());
            valueList = new ArrayList<Integer>(frequencyMap.values());

        }

        return valueList;
    }
    @GetMapping("getTotalCustomers")
    @ResponseBody
    public List<Integer> getTotalCustomers() {
        List<Date> dates = new ArrayList<>();
        ArrayList<Integer> keyList = new ArrayList<>();
        ArrayList<Integer> valueList = new ArrayList<>();
        List<Integer> dates1 = new ArrayList<>();
        ArrayList dates2 = new ArrayList<>();
        List<User> customers = userService.getTotalCustomers();
        for (User customer : customers) {
            Date date = customer.getDate(); // the date instance
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            dates1.add(calendar.get(Calendar.MONTH) + 1);

        }

        CustomerChartDto customerChartDtoItem = new CustomerChartDto();
        List<CustomerChartDto> customerChartDto = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer s : dates1) {
            Integer count = frequencyMap.get(s);
            if (count == null) {
                count = 0;
            }

            frequencyMap.put(s, count + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            keyList = new ArrayList<Integer>(frequencyMap.keySet());
            valueList = new ArrayList<Integer>(frequencyMap.values());

        }

        return valueList;
    }

    @PostMapping("getCartProducts")
    @ResponseBody
    public List<Product> getCartProducts(@RequestBody ShoppingCartDto shoppingCartDto) {
        List<Integer> ids = shoppingCartDto.getId();

        return itemService.getCartProducts(ids);
    }

    @PostMapping("saveOrder")
    public void saveOrder(@RequestBody OrdersDto ordersdto) {
int x = (int) (Math.random() * ((20000000 - 10000000) + 1) + 10000000);
        List<OrderLine> orders = new ArrayList<>();
        List<Product> products = ordersdto.getCartProducts();

        for (Product product : products) {
            OrderLine tempOder = new OrderLine();
            tempOder.setAddress(ordersdto.getAddress());
            tempOder.setCountry(ordersdto.getCountry());
            tempOder.setDate(ordersdto.getDate());
            tempOder.setPhoneNumber(ordersdto.getPhoneNumber());
            tempOder.setProductId(product.getId());
            tempOder.setOrderId(x);
           
            orderRepository.save(tempOder);
        }

    }

    @RequestMapping("/calendar")
    public String calendar() {
        return "calendar";
    }

    @RequestMapping("/map")
    public String map() {
        return "map";
    }

    @RequestMapping("/maindashboard")
    public String maindashboard() {
        return "maindashboard";
    }

}
