package org.nadarkanloev.vkbackendtest.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.nadarkanloev.vkbackendtest.DTO.JwtAuthenticationResponse;
import org.nadarkanloev.vkbackendtest.DTO.SignUpRequest;
import org.nadarkanloev.vkbackendtest.Service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> signUp(@RequestBody @Valid SignUpRequest request) {
        String response = authService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/authorize")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody @Valid SignUpRequest signUpRequest){
        JwtAuthenticationResponse response = authService.signIn(signUpRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/feed")
    public ResponseEntity<Void> feed(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
