package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodes")
@RequiredArgsConstructor
public class EpisodeController {
    private final EpisodeService episodeService;

    @PostMapping
    public void createEpisode(@Valid @RequestBody EpisodeDTO episodeDTO) {
        episodeService.createEpisode(episodeDTO);
    }
}
