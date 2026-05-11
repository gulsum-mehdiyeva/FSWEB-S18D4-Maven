package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerErrorException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void validateBurger(Burger burger) throws Exception {
        if (burger.getName() == null || burger.getName().trim().isEmpty()) {
            throw new BurgerErrorException("Burger ismi bos olamaz", HttpStatus.BAD_REQUEST);
        }

        if (burger.getPrice() <= 0) {
            throw new BurgerErrorException("Fiyat 0'dan büyük olmalidir", HttpStatus.BAD_REQUEST);
        }
    }
}
