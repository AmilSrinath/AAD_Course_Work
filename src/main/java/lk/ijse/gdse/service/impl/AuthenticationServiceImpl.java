package lk.ijse.gdse.service.impl;

import lk.ijse.gdse.DAO.UserDAO;
import lk.ijse.gdse.DTO.UserDTO;
import lk.ijse.gdse.Entity.Role;
import lk.ijse.gdse.Entity.User;
import lk.ijse.gdse.conversion.Mapping;
import lk.ijse.gdse.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.reqAndresp.secure.SignIn;
import lk.ijse.gdse.reqAndresp.secure.SignUp;
import lk.ijse.gdse.service.AuthenticationService;
import lk.ijse.gdse.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Amil Srinath
 */
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private  final UserDAO userDAO;
    private final Mapping mapping;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var userByEmail = userDAO.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        String token = jwtService.generateToken(userByEmail);
        return JwtAuthResponse.builder().token(token).build();
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        UserDTO build = UserDTO.builder()
                .userId(UUID.randomUUID().toString())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(Role.valueOf(signUp.getRole()))
                .build();

        User user = userDAO.save(mapping.toUser(build));
        String generateToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(generateToken).build();
    }

    @Override
    public JwtAuthResponse refreshToken(String tokenAccess) {
        String username = jwtService.extractUsername(tokenAccess);
        User user = userDAO.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        String refreshToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(refreshToken).build();
    }
}
