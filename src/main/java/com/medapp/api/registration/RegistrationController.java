package com.medapp.api.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/registration")
@AllArgsConstructor
public class RegistrationController {
    RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
    @GetMapping(path = "confirm")
    @ResponseBody
    public String confirm(@RequestParam(name="token") String token) {
        return registrationService.confirmToken(token);
    }

}
