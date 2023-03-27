package com.novatlas.command.repository;

import com.novatlas.command.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command,Long> {
}
