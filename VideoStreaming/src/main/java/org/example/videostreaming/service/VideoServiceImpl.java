package org.example.videostreaming.service;

import jakarta.annotation.PostConstruct;
import org.example.videostreaming.model.Video;
import org.example.videostreaming.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    VideoRepository videoRepository;


    @Value("${files.videos}")
    String DIR;

    @PostConstruct
    public void init(){
        File file = new File(DIR);

        if(!file.exists()){
            file.mkdir();
            System.out.println("Folder is created...");
        }else{
            System.out.println("Folder already created....");
        }
    }

    @Override
    public Video save(Video video, MultipartFile file)  {
        try {
            // create a folder
            String filename = file.getOriginalFilename();
            String ContentType = file.getContentType();
            InputStream inputStream = file.getInputStream();

            String cleanPathName = StringUtils.cleanPath(filename);
            String cleanfolderName = StringUtils.cleanPath(DIR);

            Path path = Paths.get(cleanfolderName,cleanPathName);
            System.out.println(path);

            //copy file to the folder created
            Files.copy(inputStream,path, StandardCopyOption.REPLACE_EXISTING);

            //video Meta data
            video.setContentType(ContentType);
            video.setFilePath(path.toString());

            //save meta data
            return videoRepository.save(video);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Video get(String videoId) {
        Video video = videoRepository.findById(videoId).orElseThrow(()->new RuntimeException("video not found"));
        return video;
    }

    @Override
    public Video getByTitle(String videoTitle) {
        return null;
    }

    @Override
    public List<Video> getAll() {
        return videoRepository.findAll();
    }


}
