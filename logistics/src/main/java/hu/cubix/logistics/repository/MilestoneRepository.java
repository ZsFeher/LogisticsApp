package hu.cubix.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.cubix.logistics.model.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone,Long> {
}
