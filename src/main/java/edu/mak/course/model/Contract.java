package edu.mak.course.model;

import lombok.*;

import java.time.Instant;
import java.util.Date;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    private Long id;
    private Organization organization;
    private Hotel hotel;
    private float sale ;
    private Group group;
    private Date date;
    private Instant createdAt;
    private Instant updatedAt;
}
