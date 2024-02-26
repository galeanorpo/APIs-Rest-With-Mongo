package com.mongo.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Product")
public class Product implements Serializable {

    @Id
    @NonNull
    private Long id;
    private String imagePath;
    private String title;
    private String description;

}
