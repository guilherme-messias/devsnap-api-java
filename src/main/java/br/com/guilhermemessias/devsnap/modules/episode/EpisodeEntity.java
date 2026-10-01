package br.com.guilhermemessias.devsnap.modules.episode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EpisodeEntity {
    @NotBlank(message = "ID cannot be blank")
    private String id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Error cannot be blank")
    private String error;

    @NotBlank(message = "Solution cannot be blank")
    private String solution;
}
