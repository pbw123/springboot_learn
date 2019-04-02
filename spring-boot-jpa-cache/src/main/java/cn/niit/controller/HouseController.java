package cn.niit.controller;

import cn.niit.entity.House;
import cn.niit.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 潘炳稳 on 2019/4/2.
 */
@RestController
public class HouseController {
    @Autowired
    private HouseRepository houseRepository;

    // @CachePut注解，这个注解直接将返回值放入缓存中，通常用于保存和修改方法中
    @GetMapping("/saveHouse")
    @CachePut(value = "house", key = "#id")
    public House saveHouse(Integer id, String houseName, String houseSize) {
        House house = new House(id, houseName, houseSize);
        houseRepository.save(house);
        return house;
    }

    //@Cacheable注解，这个注解在执行前先查看缓存中是不是已经存在了，如果存在，直接返回。如果不存在，将方法的返回值放入缓存。
    @GetMapping("/queryHouse")
    @Cacheable(value = "house", key = "#id")
    public House queryHouse(Integer id) {
        House house = houseRepository.findOne(id);
        return house;
    }
//@CacheEvict注解，这个注解在执行方法执行成功后会从缓存中移除
    @GetMapping("/deleteHouse")
    @CacheEvict(value = "house", key = "#id")
    public String deleteHouse(Integer id) {
        houseRepository.delete(id);
        return "删除成功";
    }
//@CacheEvict注解，不同的是使用了allEntries熟悉，默认为false，true的时候移除所有缓存。
    @GetMapping("/deleteCacheAll")
    @CacheEvict(value = "house", allEntries = true)
    public String deleteCacheAll() {
        return "删除所有缓存";
    }
}
