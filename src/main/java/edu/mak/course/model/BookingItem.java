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
public class BookingItem {
    private Long id;
    private Booking booking;
    private Amenity amenity;
    private int count;
    private String measurementUnit;
    private float orderingPrice;

}
