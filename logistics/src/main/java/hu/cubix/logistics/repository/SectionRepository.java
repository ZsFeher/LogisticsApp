package hu.cubix.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.cubix.logistics.model.Section;

public interface SectionRepository extends JpaRepository<Section,Long> {

}
