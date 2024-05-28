package com.activity3.feedback.dto;

import lombok.Data;

@Data
public class FeedbackDTO
{
    private Long userId;
    private String comments;
    private int rating;
}
