package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import edu.mak.course.dao.annotation.CascadeSave;
import lombok.*;
import lombok.extern.jackson.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Document(collection = "building")
@QueryEntity
@Data
@Jacksonized
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Building {

    @Id
    private String id;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("hotel")
    private Hotel hotel;

    @Field("floorCount")
    private int floorCount;

    @Field("roomCount")
    private int roomCount;

    @Field("starCount")
    private int starCount;

    @Field("hotelBuildingAmenity")
    private List<Amenity> hotelAmenities;
}
