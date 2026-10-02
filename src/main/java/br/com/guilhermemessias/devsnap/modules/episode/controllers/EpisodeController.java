package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episodes")
@RequiredArgsConstructor
public class EpisodeController {
    private final EpisodeService episodeService;

    @PostMapping
    public void createEpisode(@Valid @RequestBody EpisodeDTO episodeDTO) {
        episodeService.createEpisode(episodeDTO);
    }

    @GetMapping
    public List<EpisodeDTO> getAllEpisodes() {
        return episodeService.getAllEpisodes();
    }

    @GetMapping("/{id}")
    public EpisodeDTO getEpisodeById(@PathVariable String id) {
        return episodeService.getEpisodeById(id);
    }
}
