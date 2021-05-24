package edu.mak.course.data;

import edu.mak.course.dao.model.Organization;
import edu.mak.course.dao.model.OrganizationType;
import edu.mak.course.dao.model.Traveller;
import edu.mak.course.dao.model.TravellerGroup;
import lombok.*;
import org.springframework.stereotype.Repository;

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

    private List<Traveller> travellers = Collections.emptyList();

    private List<Organization> organizations = Arrays.asList(
        new Organization("1", "EuroTour", OrganizationType.TOURIST_ORGANIZATION),
        new Organization("2", "CHNU", OrganizationType.CONDUCTING_INTERNATIONAL_EVENTS),
        new Organization("3", "AMORE", OrganizationType.TOURIST_ORGANIZATION));

    private List<TravellerGroup> travellerGroups = Collections.emptyList();
}
