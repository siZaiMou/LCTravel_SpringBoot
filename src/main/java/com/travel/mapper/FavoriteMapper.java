package com.travel.mapper;

import com.travel.domain.Favorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface FavoriteMapper
{
    int findCountByRid(int rid);

    void add(@Param("rid") int rid, @Param("date") Date date, @Param("uid") int uid);

    void delete(@Param("rid") int rid, @Param("uid") int uid);

    Favorite findByRidAndUid(@Param("rid") int rid, @Param("uid") int uid);

    List<Integer> finByUid(int uid);

}
