package edu.mak.course.data;

import edu.mak.course.dao.model.Group;
import edu.mak.course.dao.model.Organization;
import edu.mak.course.dao.model.OrganizationType;
import edu.mak.course.dao.model.Traveller;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@Repository
public class FakeData {

    private List<Traveller> travellers = Arrays.asList(
        new Traveller("1", "Makydon Sofiia", LocalDate.of(2001, 5, 25),
            "00012345", "+380958723212"),
        new Traveller("2", "Julia Roberts", LocalDate.of(1979, 6, 1),
            "00009876", "+380668723212"),
        new Traveller("3", "Tim Burton", LocalDate.of(1980, 12, 23),
            "00154879", "+380995487562"),
        new Traveller("4", "Jane Austin", LocalDate.of(1987, 8, 8),
            "00154872", "+380502154589"),
        new Traveller("5", "Nina Simone ", LocalDate.of(1987, 8, 8),
            "00154872", "+380502154589"));

    private List<Organization> organizations = Arrays.asList(
        new Organization("1", "EuroTour", OrganizationType.TOURIST_ORGANIZATION),
        new Organization("2", "CHNU", OrganizationType.CONDUCTING_INTERNATIONAL_EVENTS),
        new Organization("3", "AMORE", OrganizationType.TOURIST_ORGANIZATION));

    private List<Group> groups = Collections.singletonList(
        new Group("1", "1", organizations.get(1), 10));
}
