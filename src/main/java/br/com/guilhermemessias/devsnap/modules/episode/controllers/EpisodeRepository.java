package br.com.guilhermemessias.devsnap.modules.episode.controllers;

import br.com.guilhermemessias.devsnap.modules.episode.EpisodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<EpisodeEntity, Long> {
}
