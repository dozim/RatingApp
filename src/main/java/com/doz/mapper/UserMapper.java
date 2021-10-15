package com.doz.mapper;

import com.doz.model.User;
import com.doz.model.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto map(User user);
}
