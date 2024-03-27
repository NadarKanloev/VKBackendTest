package org.nadarkanloev.vkbackendtest.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nadarkanloev.vkbackendtest.DTO.JwtAuthenticationResponse;
import org.nadarkanloev.vkbackendtest.DTO.SignUpRequest;
import org.nadarkanloev.vkbackendtest.Exception.WeakPasswordException;
import org.nadarkanloev.vkbackendtest.Model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Log4j2
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * Регистрация пользователя
     *
     * @param signUpRequest Данные пользователя
     * @return
     */
    public String signUp(SignUpRequest signUpRequest){
        String checkPassword = checkPasswordStrength(signUpRequest.getPassword());
        var user = User.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();
        log.info(user.getPassword());
        userService.create(user);
        log.info("Создан пользователь " + user.getEmail() + " с айди" + user.getId());
        String response = user.getId() + " " + checkPassword;
        return response;
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signIn(SignUpRequest request){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getEmail());

        log.info("Пользователь " + user.getUsername() + " успешно вошел в систему");

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
    public String checkPasswordStrength(String password){
        if(password.length() < 8){
            throw new WeakPasswordException("Weak Password");
        }
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChars = false;

        for(int i = 0; i < password.length(); i++){
            if (Character.isDigit(password.charAt(i))) hasDigit = true;
            if(Character.isUpperCase(password.charAt(i))) hasUpperCase = true;
            if(!Character.isLetterOrDigit(password.charAt(i))) hasSpecialChars = true;
        }

        if(hasDigit && hasSpecialChars && hasUpperCase){
            return "Perfect Password";
        }else if(hasDigit || hasUpperCase || hasSpecialChars){
            return "Good Password";
        }else {
            throw new WeakPasswordException("Weak Password");
        }

    }
}
