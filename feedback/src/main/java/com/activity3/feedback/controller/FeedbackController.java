package com.activity3.feedback.controller;


import com.activity3.feedback.Entity.Feedback;
import com.activity3.feedback.Repository.FeedbackRepository;
import com.activity3.feedback.dto.FeedbackDTO;
import com.activity3.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public FeedbackDTO submitFeedback(@RequestBody FeedbackDTO feedbackDTO)
    {
        return feedbackService.submitFeedback(feedbackDTO);
    }

    @GetMapping
    public List<FeedbackDTO> getAllFeedback()
    {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{userId}")
    public List<FeedbackDTO> getFeedbackByUserId(@PathVariable Long userId) {
        return feedbackService.getFeedbackByUserId(userId);
    }
}