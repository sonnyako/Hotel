package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import edu.mak.course.dao.annotation.CascadeSave;
import lombok.*;
import lombok.extern.jackson.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Document(collection = "travellerGroup")
@QueryEntity
@Data
@Jacksonized
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TravellerGroup {

    @Id
    private String id;

    @Field("name")
    private String name;

    @DBRef(lazy = true)
    @CascadeSave
    @Field("organization")
    private Organization organization;

    @Field("travellerCount")
    private int travellerCount;
}
