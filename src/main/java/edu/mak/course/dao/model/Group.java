package edu.mak.course.dao.model;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    @Id
    private String id;
    private String name;
    private Organization organization;
    private int travellerCount;

    public Group(String name, Organization organization, int travellerCount) {
        this.name = name;
        this.organization = organization;
        this.travellerCount = travellerCount;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTravellerCount() {
        return travellerCount;
    }

    public void setTravellerCount(int travellerCount) {
        this.travellerCount = travellerCount;
    }
}
