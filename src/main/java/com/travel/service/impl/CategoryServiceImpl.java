package com.travel.service.impl;

import com.travel.domain.Category;
import com.travel.mapper.CategoryMapper;
import com.travel.service.CategoryService;
import com.travel.util.JedisUtil;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service //被zookeeper扫描，注册到注册中心
@Component
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll()
    {
        List<Category> categoryList = null;
        Jedis jedis = JedisUtil.getJedis();
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        if(categorys==null||categorys.size()==0)
        {
            categoryList = categoryMapper.findAll();
            categoryList.forEach(li->{jedis.zadd("category",li.getCid(),li.getCname());});
        }
        else
        {
            categoryList = new ArrayList<>();
            for (Tuple tuple : categorys)
            {
                Category category = new Category();
                category.setCid((int)tuple.getScore());
                category.setCname(tuple.getElement());
                categoryList.add(category);
            }
        }
        jedis.close();
        return categoryList;
    }

    @Override
    public String provideName()
    {
        return "this is a category service";
    }
}
