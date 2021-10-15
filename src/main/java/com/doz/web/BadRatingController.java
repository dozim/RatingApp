package com.doz.web;

import com.doz.model.dto.BadRatingDto;
import com.doz.model.dto.GoodRatingDto;
import com.doz.service.ApplyRatingService;
import com.doz.service.BadRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("badratings")
@RequiredArgsConstructor
public class BadRatingController {

    private final BadRatingService badRatingService;
    private final ApplyRatingService applyRatingService;

    @PostMapping
    public void add(@RequestBody BadRatingDto badRatingDto) {
        this.applyRatingService.save(badRatingDto);
    }

    @GetMapping("/users/{userId}")
    public List<BadRatingDto> getBadRatingDtosForUser(@PathVariable long userId) {
        return this.badRatingService.getBadRatingDtosForUser(userId);
    }
}
