package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import br.com.guilhermemessias.devsnap.modules.episode.EpisodeEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {
    private final EpisodeRepository episodeRepository;

    private final ModelMapper modelMapper;

    public EpisodeDTO createEpisode(EpisodeDTO episodeDTO) {
        EpisodeEntity episodeEntity = modelMapper.map(episodeDTO, EpisodeEntity.class);
        episodeRepository.save(episodeEntity);

        return modelMapper.map(episodeEntity, EpisodeDTO.class);
    }

    public List<EpisodeDTO> getAllEpisodes() {
        List<EpisodeEntity> episodeEntities = episodeRepository.findAll();
        return episodeEntities.stream()
                .map(episodeEntity -> modelMapper.map(episodeEntity, EpisodeDTO.class))
                .toList();
    }

    public EpisodeDTO getEpisodeById(String id) {
        EpisodeEntity episodeEntity = episodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Episode not found with id: " + id));
        return modelMapper.map(episodeEntity, EpisodeDTO.class);
    }
}
