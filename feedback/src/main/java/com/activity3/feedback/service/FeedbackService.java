package com.activity3.feedback.service;

import com.activity3.feedback.dto.FeedbackDTO;

import java.util.List;

public interface FeedbackService
{
    FeedbackDTO submitFeedback(FeedbackDTO feedbackDTO);
    List<FeedbackDTO> getAllFeedback();
    List<FeedbackDTO> getFeedbackByUserId(Long userId);
}
