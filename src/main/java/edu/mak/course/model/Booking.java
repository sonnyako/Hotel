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
public class Booking {
    private Long id;
    private float totalPrice;
    private Date inDate;
    private Date outDate;
    private Instant createdAt;
    private Instant updatedAt;
}
