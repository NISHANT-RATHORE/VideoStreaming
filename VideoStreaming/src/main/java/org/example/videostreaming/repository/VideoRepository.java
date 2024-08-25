package org.example.videostreaming.repository;

import org.example.videostreaming.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video,String> {
    Optional<Video> findByVideoTitle(String title);
}
