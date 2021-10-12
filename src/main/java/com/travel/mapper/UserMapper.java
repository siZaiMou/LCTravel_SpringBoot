package com.travel.mapper;

import com.travel.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper
{
    User findByUser(User user);

    User findByUsername(String username);

    void save(User user);

    User findByCode(String code);

    void updateStatus(User user);
}
