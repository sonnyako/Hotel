package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import edu.mak.course.dao.annotation.CascadeSave;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Embedded;
import java.io.Serializable;

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
public class BookingItem implements Serializable {

    private static final long serialVersionUID = -7062706625971239813L;

    @Id
    private String id;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("booking")
    private Booking booking;

    @Embedded
    @Field("amenity")
    private Amenity amenity;

    @Field("count")
    private int count;

    @Field("measurementUnit")
    private String measurementUnit;

    @Field("orderingPrice")
    private double orderingPrice;
}
