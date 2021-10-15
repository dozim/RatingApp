package com.doz.service;

import com.doz.mapper.BadRatingMapper;
import com.doz.model.BadRating;
import com.doz.model.User;
import com.doz.model.dto.BadRatingDto;
import com.doz.model.dto.GoodRatingDto;
import com.doz.repository.BadRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BadRatingService {

    private final BadRatingRepository badRatingRepository;
    private final BadRatingMapper badRatingMapper;

    @Transactional
    @Modifying
    public void save(BadRating badRating) {
        this.badRatingRepository.save(badRating);
    }

    public List<BadRatingDto> getBadRatingDtosForUser(long userId) {
        User user = User.builder().id(userId).build();

        return this.badRatingRepository
                .queryByUser(user)
                .stream()
                .map(this.badRatingMapper::map)
                .collect(Collectors.toList());
    }
}
