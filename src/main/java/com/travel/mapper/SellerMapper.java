package com.travel.mapper;

import com.travel.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SellerMapper
{
    Seller findById(int sid);
}
