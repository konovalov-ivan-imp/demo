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
public class UserData {

    @JsonProperty("id")
    public int id;

    @JsonProperty("username")
    public String username;

}
