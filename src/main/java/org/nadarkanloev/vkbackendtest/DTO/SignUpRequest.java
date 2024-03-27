package org.nadarkanloev.vkbackendtest.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Запрос на вход в систему.

 * Этот класс используется для передачи данных о имени пользователя и пароле при входе в систему.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpRequest {

    @NotBlank(message = "Поле адреса электронной почты не должно быть пустым")
    private String email;

    private String password;
}
