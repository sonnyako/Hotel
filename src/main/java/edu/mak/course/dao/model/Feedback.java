package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import edu.mak.course.dao.annotation.CascadeSave;
import lombok.*;
import lombok.extern.jackson.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Document(collection = "feedback")
@QueryEntity
@Data
@Jacksonized
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Feedback implements Serializable {

    private static final long serialVersionUID = -1026487006378094918L;

    @Id
    private String id;

    @Field("text")
    private String text;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("traveller")
    private Traveller traveller;

    @Field("priceRating")
    private int priceRating;

    @Field("serviceRating")
    private int serviceRating;

    @Field("createdAt")
    private Instant createdAt;

    @Field("updatedAt")
    private Instant updatedAt;
}
