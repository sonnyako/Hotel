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
@Document(collection = "room")
@QueryEntity
@Data
@Jacksonized
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Room {

    @Id
    private String id;

    @Field("type")
    private RoomType type;

    @Field("name")
    private String name;

    @Field("price")
    private double price;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("floor")
    private Floor floor;

    @Field("roomAmenities")
    private List<Amenity> roomAmenities;
}
