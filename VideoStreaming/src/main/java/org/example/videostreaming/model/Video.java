package org.example.videostreaming.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "latestVideo")
@Builder
public class Video {
    @Id
    private String videoId;

    private String videoTitle;

    private String description;

    private String contentType;

    private String filePath;

    @ManyToOne
    private Course course;
}
