package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import edu.mak.course.dao.annotation.CascadeSave;
import lombok.*;
import lombok.extern.jackson.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
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
@Jacksonized
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    @CreatedDate
    @Field("date")
    private Date date;

    @CreatedDate
    @Field("createdAt")
    private Date createdAt;

    @LastModifiedDate
    @Field("updatedAt")
    private Date updatedAt;
}
