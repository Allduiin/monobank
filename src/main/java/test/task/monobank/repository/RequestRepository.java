package test.task.monobank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.task.monobank.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
