package com.doz.mapper;

import com.doz.model.GoodRating;
import com.doz.model.dto.GoodRatingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GoodRatingMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "ratingObjectId", source = "ratingObject.id")
    GoodRatingDto map(GoodRating goodRating);

}
