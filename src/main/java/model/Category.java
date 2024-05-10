package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    private Integer id;
    private String name;
    private Boolean status;
}
