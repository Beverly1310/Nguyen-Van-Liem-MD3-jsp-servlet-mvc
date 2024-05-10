package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookRequest {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private Integer totalPages;
    private Integer yearCrated;
    private String author;
    private Boolean status;
    private Integer categoryID;
}
