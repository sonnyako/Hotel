package edu.mak.course.model;

import lombok.*;

import java.util.Date;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Traveller {
    private Long id;
    private String name;
    private Date birthday;
    private String documentNumber;
    private String phoneNumber;
    private float sale;
}
