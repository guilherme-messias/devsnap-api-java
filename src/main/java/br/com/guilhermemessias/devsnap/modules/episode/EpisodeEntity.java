package br.com.guilhermemessias.devsnap.modules.episode;

import lombok.Data;

import java.util.UUID;

@Data
public class EpisodeEntity {
    private UUID id;
    private String title;
    private String stack;
    private String solution;
    private boolean reviewed;
}
