package lk.ijse.gdse.Controller;

import lk.ijse.gdse.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.reqAndresp.secure.SignIn;
import lk.ijse.gdse.reqAndresp.secure.SignUp;
import lk.ijse.gdse.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService authenticationService;

    @GetMapping("/health")
    public String healthCheck(){
        System.out.println("----------&DONE&-----------");
        return "----------@DONE@-----------";
    }

    //singUp
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
        return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }

    //signIn
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }
}
