package com.task.demo.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Comment {

    @JsonProperty("id")
    public int id;

    @JsonProperty("body")
    public String body;
    @JsonProperty("postId")
    public int postId;
    @JsonProperty("user")
    public UserData user;
}
