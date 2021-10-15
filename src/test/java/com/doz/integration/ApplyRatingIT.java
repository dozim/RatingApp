package com.doz.integration;

import com.doz.model.RatingObject;
import com.doz.model.User;
import com.doz.model.dto.GoodRatingDto;
import com.doz.model.dto.RatingObjectDto;
import com.doz.service.ApplyRatingService;
import com.doz.service.GoodRatingService;
import com.doz.service.RatingObjectService;
import com.doz.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
public class ApplyRatingIT {

    @Container
    private static final PostgreSQLContainer POSTGRE_SQL_CONTAINER = new PostgreSQLContainer("postgres:13.4")
            .withDatabaseName("ratingdb")
            .withPassword("password")
            .withUsername("postgres");

    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
    }

    @Autowired
    private ApplyRatingService applyRatingService;

    @Autowired
    private RatingObjectService ratingObjectService;

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        // GIVEN
        RatingObject ratingObject1 = new RatingObject();
        RatingObject ratingObject2 = new RatingObject();

        ratingObjectService.save(ratingObject1);
        ratingObjectService.save(ratingObject2);

        User userTom = User
                .builder()
                .name("Tom")
                .build();

        User userFrank = User
                .builder()
                .name("Frank")
                .build();

        userService.save(userTom);
        userService.save(userFrank);

        // WHEN
        GoodRatingDto goodRatingDto = GoodRatingDto
                .builder()
                .userId(userTom.getId())
                .ratingObjectId(ratingObject1.getId())
                .build();

        applyRatingService.save(goodRatingDto);

        // THEN
        RatingObjectDto nextFreeRatingObjectDtoForTom = ratingObjectService.getNextFreeRatingObjectDto(userTom.getId());
        RatingObjectDto nextFreeRatingObjectDtoForFrank = ratingObjectService.getNextFreeRatingObjectDto(userFrank.getId());

        assertThat(nextFreeRatingObjectDtoForTom.getId())
                .isNotNull()
                .isEqualTo(ratingObject2.getId());

        assertThat(nextFreeRatingObjectDtoForFrank.getId())
                .isNotNull()
                .isEqualTo(ratingObject1.getId());
    }
}
