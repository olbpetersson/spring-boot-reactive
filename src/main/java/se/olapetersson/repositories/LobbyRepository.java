package se.olapetersson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.olapetersson.entities.Lobby;

public interface LobbyRepository extends JpaRepository<Lobby, Long> {
    Lobby findByName(String name);
    void deleteByName(String name);
}
