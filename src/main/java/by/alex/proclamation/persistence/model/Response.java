package by.alex.proclamation.persistence.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class Response {
    private int statusCode;
    private String message;
    private List<Violation> violations;

}
