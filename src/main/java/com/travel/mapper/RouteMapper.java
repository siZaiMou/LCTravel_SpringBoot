package com.travel.mapper;

import com.travel.domain.Route;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RouteMapper
{
    List<Route> findByPage(@Param("cid")int cid, @Param("rname")String rname);

    Route findOne(int rid);

    void updateCountByRid(@Param("rid") int rid,@Param("newCount") int newCount);

    List<Route> findByUid(int uid);

    List<Route> findByRids(@Param("ridList") List<Integer> ridList);

    List<Route> findRoutesByRank();
}
