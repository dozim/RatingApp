package com.doz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BadRatingDto {

    private long id;

    private long userId;

    private long ratingObjectId;

}
