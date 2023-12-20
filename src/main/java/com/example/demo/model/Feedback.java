// Generated with g9.

package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import com.example.demo.model.IdClass.FeedbackId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Feedback implements Serializable {
    @Column(name="Review")
    private String review;
    @Column(name="Time", nullable=false)
    private LocalDateTime time;
    @Column(name="Rating", precision=3)
    private short rating;
    @EmbeddedId
    private FeedbackId feedbackId;
    public Feedback() {
    	super();
    }
}
