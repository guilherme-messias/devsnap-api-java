package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import br.com.guilhermemessias.devsnap.modules.episode.EpisodeEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
