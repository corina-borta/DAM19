package org.scrum.restaurant.service;

import org.scrum.restaurant.management.Feedback;
import org.scrum.restaurant.repo.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Găsește toate feedback-urile
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    // Găsește un feedback după ID
    public Optional<Feedback> getFeedbackById(Integer id) {
        return feedbackRepository.findById(id);
    }

    // Adaugă un feedback nou
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Șterge un feedback după ID
    public void deleteFeedback(Integer id) {
        feedbackRepository.deleteById(id);
    }

    // Găsește feedback-uri după nivelul de satisfacție
    public List<Feedback> getFeedbackByNivelSatisfactie(String nivel) {
        return feedbackRepository.findByNivelSatisfactie(nivel);
    }
}
