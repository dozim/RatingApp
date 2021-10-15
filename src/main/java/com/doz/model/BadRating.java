package com.doz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "BadRating", indexes = {
        @Index(name = "idx_badrating", columnList = "rating_object_id"),
        @Index(name = "idx_badrating_user_id", columnList = "user_id")
})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BadRating {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bad_seq")
    @SequenceGenerator(name = "bad_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "rating_object_id", nullable = false)
    private RatingObject ratingObject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadRating badRating = (BadRating) o;
        return Objects.equals(id, badRating.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
