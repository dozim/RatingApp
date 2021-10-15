package com.doz.service;

import com.doz.mapper.RatingObjectMapper;
import com.doz.model.RatingObject;
import com.doz.model.dto.RatingObjectDto;
import com.doz.repository.RatingObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class RatingObjectService {

    public final RatingObjectRepository ratingObjectRepository;
    public final RatingObjectMapper ratingObjectMapper;

    public RatingObjectDto getNextFreeRatingObjectDto(long userId) {
        List<RatingObject> nextRatingWithout = this.ratingObjectRepository.findNextRating(userId, PageRequest.of(0, 1));

        return nextRatingWithout
                .stream()
                .findFirst()
                .map(this.ratingObjectMapper::map)
                .orElse(null);
    }

    public RatingObjectDto getRatingObjectDto(long id) {
        RatingObject ratingObject = this.ratingObjectRepository.getById(id);
        return this.ratingObjectMapper.map(ratingObject);
    }

    public RatingObject getRatingObject(long id) {
        return this.ratingObjectRepository.getById(id);
    }

    @Transactional
    @Modifying
    public RatingObjectDto save(RatingObject ratingObject) {
        return this.ratingObjectMapper.map(this.ratingObjectRepository.save(ratingObject));
    }
}
