package com.doz.mapper;

import com.doz.model.BadRating;
import com.doz.model.GoodRating;
import com.doz.model.dto.BadRatingDto;
import com.doz.model.dto.GoodRatingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BadRatingMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "ratingObjectId", source = "ratingObject.id")
    BadRatingDto map(BadRating badRating);

}
