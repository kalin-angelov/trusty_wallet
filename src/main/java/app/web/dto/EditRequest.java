package app.web.dto;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditRequest {

    @Size(max = 10, message = "First cant be more than 10 characters")
    private String firstName;

    @Size(max = 10, message = "Last cant be more than 10 characters")
    private String lastName;

    @Email(message = "Invalid email format")
    private String email;

    @URL(message = "Invalid URL format")
    private String profilePic;
}
