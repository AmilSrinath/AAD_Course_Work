package lk.ijse.gdse.DTO;

import lk.ijse.gdse.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Amil Srinath
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private String email;
    private String password;
    private Role role;
}
