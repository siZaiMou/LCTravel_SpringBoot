package com.travel.mapper;

import com.travel.domain.RouteImg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RouteImgMapper
{
    List<RouteImg> findByRid(int rid);
}
