package com.doz.repository;

import com.doz.model.RatingObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingObjectRepository extends JpaRepository<RatingObject, Long> {

    /**
     * Find next Rating without GoodRating from own User and less than two GoodRating from other Users
     * @param userId ownUser
     * @param pageable used to get one result
     * @return one or zero {@link RatingObject}
     */
    @Query("SELECT r FROM RatingObject r " +
            "LEFT JOIN GoodRating grOwnUser ON grOwnUser.ratingObject = r AND grOwnUser.user.id = :userId " +
            "LEFT JOIN GoodRating grOtherUser ON grOtherUser.ratingObject = r AND grOtherUser.user.id <> :userId " +
            "WHERE grOwnUser IS NULL " +
            "GROUP BY r " +
            "HAVING COUNT(grOtherUser) < 2")
    List<RatingObject> findNextRating(@Param("userId") long userId, Pageable pageable);

}
