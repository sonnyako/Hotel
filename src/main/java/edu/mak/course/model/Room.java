package edu.mak.course.model;

import lombok.*;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Long id;
    private RoomType type;
    private String name;
    private float price;
    private Floor floor;
    private List<Amenity> roomAmenities;
}
