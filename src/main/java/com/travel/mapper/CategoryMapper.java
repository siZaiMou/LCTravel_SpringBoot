package com.travel.mapper;

import com.travel.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper
{
    List<Category> findAll();
}
