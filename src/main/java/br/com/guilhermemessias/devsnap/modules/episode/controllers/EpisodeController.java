package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
    public EpisodeDTO getEpisodeById(@PathVariable @NotBlank String id) {
        return episodeService.getEpisodeById(id);
    }

    @PutMapping("/{id}")
    public void updateEpisode(@PathVariable @NotBlank String id, @Valid @RequestBody EpisodeDTO episodeDTO) {
        episodeService.updateEpisodeById(id, episodeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEpisode(@PathVariable @NotBlank String id) {
        episodeService.deleteEpisodeById(id);
    }
}
