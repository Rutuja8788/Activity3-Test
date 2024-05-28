package com.activity3.feedback.serviceimpl;

import com.activity3.feedback.Entity.Feedback;
import com.activity3.feedback.Repository.FeedbackRepository;
import com.activity3.feedback.dto.FeedbackDTO;
import com.activity3.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService
{

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public FeedbackDTO submitFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = new Feedback();
        feedback.setUserId(feedbackDTO.getUserId());
        feedback.setComments(feedbackDTO.getComments());
        feedback.setRating(feedbackDTO.getRating());
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return convertToDTO(savedFeedback);
    }

    @Override
    public List<FeedbackDTO> getAllFeedback()
    {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        return feedbackList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<FeedbackDTO> getFeedbackByUserId(Long userId)
    {
        List<Feedback> feedbackList = feedbackRepository.findByUserId(userId);
        return feedbackList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private FeedbackDTO convertToDTO(Feedback feedback) {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setUserId(feedback.getUserId());
        feedbackDTO.setComments(feedback.getComments());
        feedbackDTO.setRating(feedback.getRating());
        return feedbackDTO;
    }
}
