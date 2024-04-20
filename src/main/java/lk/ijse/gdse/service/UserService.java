package lk.ijse.gdse.service;

import lk.ijse.gdse.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Amil Srinath
 */
public interface UserService {
    void save(UserDTO userDTO) throws Exception;
    UserDetailsService userDetailsService();
}
