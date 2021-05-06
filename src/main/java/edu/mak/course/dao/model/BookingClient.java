package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import edu.mak.course.dao.annotation.CascadeSave;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
public class BookingClient {

    @Id
    private String id;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("traveller")
    private Traveller traveller;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("booking")
    private Booking booking;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("room")
    private Room room;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("group")
    private Group group;
}
