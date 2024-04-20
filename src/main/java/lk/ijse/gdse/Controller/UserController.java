package lk.ijse.gdse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/health")
    public String healthCheck(){
        System.out.println("----------&DONE&-----------");
        return "----------@DONE@-----------";
    }
}
