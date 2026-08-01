package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import br.com.guilhermemessias.devsnap.modules.episode.EpisodeEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EpisodeController {
    @PostMapping("/episodes")
    public void createEpisode(@RequestBody EpisodeEntity episode) {
        System.out.printf(episode.getTitle());
    }
}
