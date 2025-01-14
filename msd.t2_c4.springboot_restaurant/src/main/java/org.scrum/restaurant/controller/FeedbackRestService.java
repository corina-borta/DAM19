package org.scrum.restaurant.controller;

import org.scrum.restaurant.management.Feedback;
import org.scrum.restaurant.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackRestService {

    @Autowired
    private FeedbackService feedbackService;

    // Obține toate feedback-urile
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    // Obține un feedback după ID
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Integer id) {
        Optional<Feedback> feedback = feedbackService.getFeedbackById(id);
        return feedback.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Creează un nou feedback
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

    // Actualizează un feedback existent
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(
            @PathVariable Integer id,
            @RequestBody Feedback feedbackDetails) {
        Optional<Feedback> existingFeedback = feedbackService.getFeedbackById(id);
        if (existingFeedback.isPresent()) {
            Feedback feedback = existingFeedback.get();
            feedback.setTextFeedback(feedbackDetails.getTextFeedback());
            feedback.setRating(feedbackDetails.getRating());
            feedback.setClient(feedbackDetails.getClient());
            Feedback updatedFeedback = feedbackService.saveFeedback(feedback);
            return ResponseEntity.ok(updatedFeedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Șterge un feedback după ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Integer id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }

    // Obține feedback-uri după nivelul de satisfacție
    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<List<Feedback>> getFeedbackByNivelSatisfactie(@PathVariable String nivel) {
        List<Feedback> feedbacks = feedbackService.getFeedbackByNivelSatisfactie(nivel);
        return ResponseEntity.ok(feedbacks);
    }
}

