package lk.ijse.gdse.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Amil Srinath
 */
public interface JWTService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    boolean validateToken(String token, UserDetails userDetails);
}
