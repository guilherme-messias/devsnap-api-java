package br.com.guilhermemessias.devsnap.modules.episode;

import lombok.Data;

@Data
public class EpisodeEntity {
    private String id;
    private String title;
    private String stack;
    private String solution;
    private boolean reviewed;
}
