package com.salesianostriana.dam.rest.task.repo;

import com.salesianostriana.dam.rest.task.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;

public interface TaskRepository extends JpaRepository<Task, Long> {


}
