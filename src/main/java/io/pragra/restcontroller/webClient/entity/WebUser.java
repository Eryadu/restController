package io.pragra.restcontroller.webClient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WebUser {
    @Id
    private int id;
    private String name;
    private String login;
    private String type;
    private String location;
    private String avatar_url;
    private String url;
}
