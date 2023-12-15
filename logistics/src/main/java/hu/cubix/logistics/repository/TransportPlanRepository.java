package hu.cubix.logistics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.cubix.logistics.model.Section;
import hu.cubix.logistics.model.TransportPlan;

public interface TransportPlanRepository extends JpaRepository<TransportPlan,Long> {

	@Query(value = "SELECT s FROM TransportPlan t JOIN t.sections s WHERE t.transportPlanId = :transportPlanId AND (s.startMileStone.id = :mileStoneId OR s.endMilestone.id = :mileStoneId)")
	Section findByMileStoneId(@Param("transportPlanId") long transportPlanId, @Param("mileStoneId") long mileStoneId);

	@Query(value = "SELECT s FROM TransportPlan t JOIN t.sections s WHERE t.transportPlanId = :transportPlanId AND s.sectionOrder = :nextSectionOrder ")
	Section findNextSection(@Param("transportPlanId") long transportPlanId, @Param("nextSectionOrder") int nextSectionOrder);

}
