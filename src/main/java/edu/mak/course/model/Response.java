package edu.mak.course.model;

import lombok.*;

import java.time.Instant;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Long id;
    private String text;
    private Traveller traveller;
    private int priceRating;
    private int serviceRating;
    private Instant createdAt;
    private Instant updatedAt;
}
