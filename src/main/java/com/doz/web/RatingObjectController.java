package com.doz.web;

import com.doz.model.RatingObject;
import com.doz.model.dto.RatingObjectDto;
import com.doz.service.RatingObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ratingobjects")
@RequiredArgsConstructor
public class RatingObjectController {

    private final RatingObjectService ratingObjectService;

    @GetMapping("/{id}")
    public RatingObjectDto getUserDto(@PathVariable long id) {
        return this.ratingObjectService.getRatingObjectDto(id);
    }

    @GetMapping("/users/{userId}")
    public RatingObjectDto getNextFreeRatingObjectDto(@PathVariable long userId) {
        return this.ratingObjectService.getNextFreeRatingObjectDto(userId);
    }

    @PostMapping
    public RatingObjectDto save(@RequestBody RatingObject ratingObject) {
        return this.ratingObjectService.save(ratingObject);
    }
}
