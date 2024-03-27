package org.nadarkanloev.vkbackendtest.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Ответ с токеном доступа.

 * Этот класс используется для передачи токена доступа клиенту после успешной аутентификации.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {
    /**
     * Токен доступа.
     *
     * Токен используется для аутентификации пользователя в системе.
     *
     * @example eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyMjUwNj...
     */
    private String token;
}
