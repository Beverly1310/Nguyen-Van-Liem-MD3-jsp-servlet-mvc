package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Book {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private Integer totalPages;
    private Integer yearCreated;
    private String author;
    private Boolean status;
    private Category category;
}
