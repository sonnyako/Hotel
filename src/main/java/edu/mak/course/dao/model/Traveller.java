package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Document
@QueryEntity
@Data
@Schema(description = "Travellers personal information")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))

public class Traveller {

    @Id
    private String id;

    @Field("name")
    @Schema(description = "Full traveller name", defaultValue = "Will Smith Olegovich")
    private String name;

    @Field("birthday")
    @Schema(description = "Day of birth")
    private LocalDate birthday;

    @Field("documentNumber")
    @Schema(description = "Passport document number", defaultValue = "00987654")
    private String documentNumber;

    @Field("phoneNumber")
    @Schema(description = "Phone number with country code", defaultValue = "+380958723212")
    private String phoneNumber;
}
