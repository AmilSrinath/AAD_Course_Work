package lk.ijse.gdse.service;

import lk.ijse.gdse.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.reqAndresp.secure.SignIn;
import lk.ijse.gdse.reqAndresp.secure.SignUp;

/**
 * @author Amil Srinath
 */
public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
    JwtAuthResponse refreshToken(String tokenAccess);
}
