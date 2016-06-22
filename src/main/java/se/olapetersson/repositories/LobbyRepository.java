package se.olapetersson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import se.olapetersson.entities.Lobby;

import javax.transaction.Transactional;

public interface LobbyRepository extends JpaRepository<Lobby, Long> {
    Lobby findByName(String name);

    @Transactional
    @Modifying
    void deleteByName(String name);
}
