package com.doz.repository;

import com.doz.model.BadRating;
import com.doz.model.GoodRating;
import com.doz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BadRatingRepository extends JpaRepository<BadRating, Long> {

    List<BadRating> queryByUser(User user);

}
