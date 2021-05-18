package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import edu.mak.course.dao.annotation.CascadeSave;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

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
public class Contract {

    @Id
    private String id;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("organization")
    private Organization organization;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("hotel")
    private Hotel hotel;

    @Field("discount")
    private double discount;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("group")
    private TravellerGroup travellerGroup;

    @Field("date")
    private Date date;

    @Field("createdAt")
    private Date createdAt;

    @Field("updatedAt")
    private Date updatedAt;
}
