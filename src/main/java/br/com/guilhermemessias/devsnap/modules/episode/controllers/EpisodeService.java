package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import br.com.guilhermemessias.devsnap.modules.episode.EpisodeEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<EpisodeDTO> getAllEpisodes(Pageable pageable) {
        return episodeRepository.findAll(pageable).map(episodeEntity -> modelMapper.map(episodeEntity, EpisodeDTO.class));
    }

    public EpisodeDTO getEpisodeById(String id) {
        EpisodeEntity episodeEntity = episodeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Episode not found with id: " + id));
        return modelMapper.map(episodeEntity, EpisodeDTO.class);
    }

    public EpisodeDTO updateEpisodeById(String id, EpisodeDTO episodeDTO) {
        EpisodeEntity episodeEntity = episodeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Episode not found with id: " + id));

        modelMapper.map(episodeDTO, episodeEntity);
        episodeEntity.setId(id);

        episodeRepository.save(episodeEntity);

        return modelMapper.map(episodeEntity, EpisodeDTO.class);
    }

    public void deleteEpisodeById(String id) {
        EpisodeEntity episodeEntity = episodeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Episode not found with id: " + id));

        episodeRepository.delete(episodeEntity);
    }
}
