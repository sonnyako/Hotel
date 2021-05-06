package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Document
@QueryEntity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
public class Hotel {

    @Id
    private String id;

    @Field("hotelName")
    private String hotelName;

    @Field("city")
    private String city;

    @Field("street")
    private String street;

    @Field("description")
    private String description;

    @Field("buildingCount")
    private int buildingCount;
}
