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
public class BookingClient {
    private Long id;
    private Traveller traveller;
    private Booking booking;
    private Room room;
    private Group group;
}
