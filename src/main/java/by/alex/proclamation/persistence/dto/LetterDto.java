package by.alex.proclamation.persistence.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Component
@Validated
public class LetterDto {
    private Long id;
    @NotBlank
    @Size(max = 22)
    private String name;
    @NotBlank
    @Size(max = 25)
    @Pattern(regexp = "\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*\\.\\w{2,4}", message = "Не соответствует формату email адреса")
    private String email;
    @NotBlank
    @Size(max = 15)
    private String phone;
    private String prof;
}
