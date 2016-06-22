package se.olapetersson.entities;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Lobby extends AbstractPersistable<Long> {
    @Column(unique = true, nullable = false)
    private String name;

    public Lobby() {
    }

    public Lobby(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
