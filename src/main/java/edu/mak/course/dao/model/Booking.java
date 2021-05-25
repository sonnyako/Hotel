package edu.mak.course.dao.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.PersistenceConstructor;
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
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
public class Booking {

    @Id
    private String id;

    @Field("totalPrice")
    private double totalPrice;

    @Field("checkIn")
    private Date checkIn;

    @Field("checkOut")
    private Date checkOut;

    @Field("discount")
    private double discount;

    @CreatedDate
    @Field("createdAt")
    private Date createdAt;

    @LastModifiedDate
    @Field("updatedAt")
    private Date updatedAt;
}
