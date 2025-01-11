package org.scrum.restaurant.repo;

import org.scrum.restaurant.management.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    // Găsește feedback-uri după rating
    List<Feedback> findByRating(Integer rating);

    // Găsește feedback-uri după nivelul de satisfacție
    List<Feedback> findByNivelSatisfactie(String nivel);

    // Poți adăuga alte metode personalizate dacă este nevoie
}
