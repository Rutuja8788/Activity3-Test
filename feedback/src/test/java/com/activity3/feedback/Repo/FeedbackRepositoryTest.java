package com.activity3.feedback.Repo;

import com.activity3.feedback.Entity.Feedback;
import com.activity3.feedback.Repository.FeedbackRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)// Use embedded database
class FeedbackRepositoryTest {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Test
    void findByUserId()
    {
        // Create and save a feedback entry
        Feedback feedback1 = new Feedback();
        feedback1.setUserId(1234L);
        feedback1.setComments("Good.");
        feedbackRepository.save(feedback1);

        // Retrieve feedback entries by user ID
        List<Feedback> feedbackList = feedbackRepository.findByUserId(1234L);

        // Assert the feedback entry was retrieved correctly
        assertTrue(feedbackList.stream().anyMatch(fb -> fb.getComments().equals("Good")));
    }
}