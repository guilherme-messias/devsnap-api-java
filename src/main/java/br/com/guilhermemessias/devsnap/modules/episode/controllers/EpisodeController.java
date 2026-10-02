package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EpisodeDTO> updateEpisode(@PathVariable @NotBlank String id, @Valid @RequestBody EpisodeDTO episodeDTO) {
        EpisodeDTO updatedEpisode = episodeService.updateEpisodeById(id, episodeDTO);
        return ResponseEntity.ok(updatedEpisode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpisode(@PathVariable @NotBlank String id) {
        episodeService.deleteEpisodeById(id);
        return ResponseEntity.noContent().build();
    }
}
