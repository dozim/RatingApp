package com.doz.mapper;

import com.doz.model.RatingObject;
import com.doz.model.dto.RatingObjectDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingObjectMapper {

    RatingObjectDto map(RatingObject ratingObject);
}
