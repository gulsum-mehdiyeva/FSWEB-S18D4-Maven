package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerErrorException;
import com.workintech.s18d1.exceptions.BurgerErrorResponse;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.AbstractDocument;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao){
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> listAll() {

        try{
            return burgerDao.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw  new BurgerErrorException( "listelerken bir hata olustu",HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/{id}")
    public Burger burgerById(@PathVariable long id){
        return burgerDao.findById(id);
    }
    @PostMapping
    public  Burger addBurger(@RequestBody Burger burger) throws Exception {

        BurgerValidation.validateBurger(burger);
        return burgerDao.save(burger);
    }
    @PutMapping("/{id}")
    public Burger updateBurger(@PathVariable long id,@RequestBody Burger burger){
        burger.setId(id);
        return  burgerDao.update(burger);
    }
    @DeleteMapping("/{id}")
    public  Burger deleteBurger(@PathVariable long id){
        return burgerDao.remove(id);
    }
    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable  double price){
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType){
        return  burgerDao.findByBreadType(breadType);
    }
    @GetMapping("/findByContent/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }}
