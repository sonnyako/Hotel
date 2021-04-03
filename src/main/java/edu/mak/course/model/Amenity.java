package edu.mak.course.model;

import lombok.*;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Amenity {
    private Long id;
    private String name;
    private String description;
}
