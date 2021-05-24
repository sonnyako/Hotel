package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import lombok.extern.jackson.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Document(collection = "traveller")
@QueryEntity
@Data
@Jacksonized
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Traveller implements Serializable {

    private static final long serialVersionUID = 6709805190064687742L;
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
