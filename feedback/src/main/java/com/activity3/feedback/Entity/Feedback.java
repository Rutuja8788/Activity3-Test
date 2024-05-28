package com.activity3.feedback.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "feedback")
public class Feedback
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
   // @SequenceGenerator(name = "feedback_seq", sequenceName = "feedback_id_seq", allocationSize = 1)
    private Long id;
    private Long userId;
    private String comments;
    private int rating;



    /*public Feedback() {}

    public Feedback(Long userId, String comments, int rating)
    {
        this.userId = userId;
        this.comments = comments;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }*/
}

