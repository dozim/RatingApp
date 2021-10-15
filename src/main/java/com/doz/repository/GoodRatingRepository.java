package com.doz.repository;

import com.doz.model.GoodRating;
import com.doz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodRatingRepository extends JpaRepository<GoodRating, Long> {

    List<GoodRating> queryByUser(User user);

}
