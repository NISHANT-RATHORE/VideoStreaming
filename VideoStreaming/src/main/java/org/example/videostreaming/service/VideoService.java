package org.example.videostreaming.service;

import org.example.videostreaming.model.Video;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface VideoService {
    Video save(Video video, MultipartFile file) throws IOException;

    Video get(String videoId);

    Video getByTitle(String videoTitle);

    List<Video> getAll();

}
