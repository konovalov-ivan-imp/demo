package com.task.demo.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CommentResponse {

    @JsonProperty("comments")
    public List<Comment> comments;

    @JsonProperty("total")
    public int total;

    @JsonProperty("limit")
    public int limit;

    @JsonProperty("skip")
    public int skip;

}
