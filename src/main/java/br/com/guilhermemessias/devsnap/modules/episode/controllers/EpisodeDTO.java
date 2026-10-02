package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodeDTO {
    private String id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Error cannot be blank")
    private String error;

    @NotBlank(message = "Solution cannot be blank")
    private String solution;
}
