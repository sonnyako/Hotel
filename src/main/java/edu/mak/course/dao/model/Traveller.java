package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Document(collection = "traveller")
@QueryEntity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
public class Traveller {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("birthday")
    private LocalDate birthday;

    @Field("documentNumber")
    private String documentNumber;

    @Field("phoneNumber")
    private String phoneNumber;
}
