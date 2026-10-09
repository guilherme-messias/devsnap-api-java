package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/episodes")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class EpisodeController {
    private final EpisodeService episodeService;

    @PostMapping
    public ResponseEntity<EpisodeDTO> createEpisode(@Valid @RequestBody EpisodeDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        EpisodeDTO episodeDTO = episodeService.createEpisode(dto);
        URI uri = uriComponentsBuilder.path("/episodes/{id}").buildAndExpand(episodeDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(episodeDTO);
    }

    @GetMapping
    public ResponseEntity<Page<EpisodeDTO>> getAllEpisodes(@PageableDefault Pageable pageable) {
        Page<EpisodeDTO> episodes = episodeService.getAllEpisodes(pageable);
        return ResponseEntity.ok(episodes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpisodeDTO> getEpisodeById(@PathVariable @NotBlank String id) {
       EpisodeDTO episodeDTO = episodeService.getEpisodeById(id);
        return ResponseEntity.ok(episodeDTO);
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
