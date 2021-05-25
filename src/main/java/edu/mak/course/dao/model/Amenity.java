package edu.mak.course.dao.model;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Amenity {

    private String name;

    private String description;
}
