package hu.cubix.logistics.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import hu.cubix.logistics.dto.AddressDto;
import hu.cubix.logistics.dto.MilestoneDto;
import hu.cubix.logistics.dto.SectionDto;
import hu.cubix.logistics.dto.TransportPlanDto;
import hu.cubix.logistics.mapper.MilestoneMapper;
import hu.cubix.logistics.mapper.SectionMapper;
import hu.cubix.logistics.mapper.TransportPlanMapper;
import hu.cubix.logistics.model.Section;
import hu.cubix.logistics.model.TransportPlan;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class DelayServiceIT {

	@Autowired
	TransportPlanService transportPlanService;

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	TransportPlanMapper transportPlanMapper;

	@Autowired
	SectionMapper sectionMapper;

	@Autowired
	MilestoneMapper milestoneMapper;

	@Test
	void testDelayService() throws Exception
	{
		AddressDto address1 = new AddressDto("HU", "Békéscsaba", "Kazinczy út", 777, 5600);
		AddressDto address2 = new AddressDto("HU", "Szeged", "Kárász utca", 777, 6722);
		AddressDto address3 = new AddressDto("NO", "Krinstiansand", "Park veien", 777, 13653);
		AddressDto address4 = new AddressDto("SE", "Malmö", "Rundelsgatan", 777, 24555);

		AddressDto a1 = createAddress(address1);
		AddressDto a2 = createAddress(address2);
		AddressDto a3 = createAddress(address3);
		AddressDto a4 = createAddress(address4);

		TransportPlanDto tp1 = new TransportPlanDto(1000);

		TransportPlanDto transportPlanDto = createTP(tp1);

		MilestoneDto milestone1 = new MilestoneDto(address1, LocalDateTime.of(2024,1,3, 10, 10));
		MilestoneDto milestone2 = new MilestoneDto(address2, LocalDateTime.of(2024,1,3, 12, 20));
		MilestoneDto milestone3 = new MilestoneDto(address3, LocalDateTime.of(2024,1,3, 15, 5));
		MilestoneDto milestone4 = new MilestoneDto(address4, LocalDateTime.of(2024,1,3, 16, 20));

		MilestoneDto m1 = createMilestone(milestone1);
		MilestoneDto m2 = createMilestone(milestone2);
		MilestoneDto m3 = createMilestone(milestone3);
		MilestoneDto m4 = createMilestone(milestone4);

		SectionDto section1 = new SectionDto(milestone1,milestone2,1,tp1);
		SectionDto section2 = new SectionDto(milestone3,milestone4,2,tp1);

		SectionDto s1 = createSection(section1);
		SectionDto s2 = createSection(section2);

		TransportPlan delayedTP = transportPlanService.addDelay(transportPlanMapper.dtoToTransportPlan(tp1), sectionMapper.dtoToSection(section1), milestoneMapper.dtoToMilestone(milestone1),30);

		Section t1s1 = delayedTP.getSections().get(0);

		assertThat(milestone1.getPlannedTime().plusMinutes(30).isEqual(t1s1.getStartMileStone().getPlannedTime()));
		//TODO
	}

	private AddressDto createAddress(AddressDto addressDto)
	{
		return webTestClient.post().uri("/api/addresses").bodyValue(addressDto).exchange().expectStatus().isOk().expectBody(AddressDto.class).returnResult().getResponseBody();
	}

	private MilestoneDto createMilestone(MilestoneDto milestoneDto)
	{
		return webTestClient.post().uri("/api/milestones").bodyValue(milestoneDto).exchange().expectStatus().isOk().expectBody(MilestoneDto.class).returnResult().getResponseBody();
	}

	private SectionDto createSection(SectionDto sectionDto)
	{
		return webTestClient.post().uri("/api/sections").bodyValue(sectionDto).exchange().expectStatus().isOk().expectBody(SectionDto.class).returnResult().getResponseBody();
	}

	private TransportPlanDto createTP(TransportPlanDto transportPlanDto)
	{
		return webTestClient.post().uri("/api/transportPlans").bodyValue(transportPlanDto).exchange().expectStatus().isOk().expectBody(TransportPlanDto.class).returnResult().getResponseBody();
	}

}
