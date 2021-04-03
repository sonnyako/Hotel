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
public class Hotel {
    private Long id;
    private String hotelName;
    private String city;
    private String street;
    private String description;
    private int buildingCount;
}
