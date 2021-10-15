package com.doz.web;

import com.doz.model.dto.GoodRatingDto;
import com.doz.service.ApplyRatingService;
import com.doz.service.GoodRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goodratings")
@RequiredArgsConstructor
public class GoodRatingController {

    private final GoodRatingService goodRatingService;
    private final ApplyRatingService applyRatingService;

    @PostMapping
    public void add(@RequestBody GoodRatingDto goodRatingDto) {
        this.applyRatingService.save(goodRatingDto);
    }

    @GetMapping("/users/{userId}")
    public List<GoodRatingDto> getGoodRatingDtosForUser(@PathVariable long userId) {
        return this.goodRatingService.getGoodRatingDtosForUser(userId);
    }
}
