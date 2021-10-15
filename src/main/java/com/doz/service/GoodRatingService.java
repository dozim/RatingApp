package com.doz.service;

import com.doz.mapper.GoodRatingMapper;
import com.doz.model.GoodRating;
import com.doz.model.User;
import com.doz.model.dto.GoodRatingDto;
import com.doz.repository.GoodRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class GoodRatingService {

    private final GoodRatingRepository goodRatingRepository;
    private final GoodRatingMapper goodRatingMapper;

    @Transactional
    @Modifying
    public void save(GoodRating goodRating) {
        this.goodRatingRepository.save(goodRating);
    }

    public List<GoodRatingDto> getGoodRatingDtosForUser(long userId) {
        User user = User.builder().id(userId).build();

        return this.goodRatingRepository
                .queryByUser(user)
                .stream()
                .map(this.goodRatingMapper::map)
                .collect(Collectors.toList());
    }
}
