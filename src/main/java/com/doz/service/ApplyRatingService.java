package com.doz.service;

import com.doz.factory.RatingFactory;
import com.doz.model.BadRating;
import com.doz.model.GoodRating;
import com.doz.model.RatingObject;
import com.doz.model.User;
import com.doz.model.dto.BadRatingDto;
import com.doz.model.dto.GoodRatingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplyRatingService {

    private final UserService userService;
    private final RatingObjectService ratingObjectService;
    private final RatingFactory ratingFactory;
    private final GoodRatingService goodRatingService;
    private final BadRatingService badRatingService;

    public void save(GoodRatingDto goodRatingDto) {
        User user = this.userService.getUser(goodRatingDto.getUserId());
        RatingObject ratingObject = this.ratingObjectService.getRatingObject(goodRatingDto.getRatingObjectId());

        GoodRating goodRating = this.ratingFactory.createGoodRating(ratingObject, user);

        this.goodRatingService.save(goodRating);
    }

    public void save(BadRatingDto badRatingDto) {
        User user = this.userService.getUser(badRatingDto.getUserId());
        RatingObject ratingObject = this.ratingObjectService.getRatingObject(badRatingDto.getRatingObjectId());

        BadRating badRating = this.ratingFactory.createBadRating(ratingObject, user);

        this.badRatingService.save(badRating);
    }
}
