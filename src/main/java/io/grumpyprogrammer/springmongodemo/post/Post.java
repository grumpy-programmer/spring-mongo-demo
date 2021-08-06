package io.grumpyprogrammer.springmongodemo.post;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("post")
public class Post {

    @Id
    private String id;

    private String title;

    private String content;

}