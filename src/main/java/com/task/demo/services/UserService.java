package com.task.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.demo.entities.UserEntity;
import com.task.demo.helpers.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

@Service
public class UserService {

    private static final String USERS_URL = "https://dummyjson.com/comments";

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll() {
        try {
            String json = jsonGetRequest(USERS_URL);
            CommentResponse response = getComments(json);

            response.comments.stream().forEach(comment -> {
                // as improvement mapper can be used here
                UserEntity userEntity = new UserEntity();
                userEntity.setId(comment.getUser().getId());
                userEntity.setBody(comment.getBody());
                userEntity.setPostId(comment.getPostId());
                String capitalizedUserName = comment.getUser().getUsername().substring(0, 1).toUpperCase() + comment.getUser().getUsername().substring(1);
                userEntity.setUsername(capitalizedUserName);
                userEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

                userRepository.save(userEntity);
            });
            userRepository.flush();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return userRepository.findAll();
    }

    /*
     * parse JSON object from string to appropriate class com.task.demo.helpers.CommentResponse
     */
    public static CommentResponse getComments(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, CommentResponse.class);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }

    /*
     * used to retrieve JSON data from URL
     */
    public static String jsonGetRequest(String urlQueryString) {
        String json = null;
        try {
            URL url = new URL(urlQueryString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

}