package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
    public Page<EpisodeDTO> getAllEpisodes(@PageableDefault Pageable pageable) {
        return episodeService.getAllEpisodes(pageable);
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
