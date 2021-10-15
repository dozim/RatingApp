package com.doz.factory;

import com.doz.model.BadRating;
import com.doz.model.GoodRating;
import com.doz.model.RatingObject;
import com.doz.model.User;
import com.doz.model.dto.BadRatingDto;
import org.springframework.stereotype.Component;

@Component
public class RatingFactory {

    public GoodRating createGoodRating(RatingObject ratingObject, User user) {
        return  GoodRating
                .builder()
                .ratingObject(ratingObject)
                .user(user)
                .build();
    }

    public BadRating createBadRating(RatingObject ratingObject, User user) {
        return  BadRating
                .builder()
                .ratingObject(ratingObject)
                .user(user)
                .build();
    }
}
