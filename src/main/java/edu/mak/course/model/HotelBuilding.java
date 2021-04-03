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
public class HotelBuilding {
    private Long id;
    private Hotel hotel;
    private int floorCount;
    private  int roomCount;
    private int starCount;
    private List<Amenity>hotelAmenities;
}
