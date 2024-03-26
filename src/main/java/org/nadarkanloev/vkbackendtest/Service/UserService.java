package org.nadarkanloev.vkbackendtest.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.nadarkanloev.vkbackendtest.Exception.UserAlreadyExistException;
import org.nadarkanloev.vkbackendtest.Exception.UserNotFoundException;
import org.nadarkanloev.vkbackendtest.Model.User;
import org.nadarkanloev.vkbackendtest.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {
    private final UserRepository userRepository;

    /**
     * <p>Сохранение пользователя</p>
     * @param user пользователь
     * @return сохраненный пользователь
     */
    public User save(User user){
        return userRepository.save(user);
    }
    /**
     * Создание пользователя
     * @param user
     * @return Созданный пользователь
     * @throws UserAlreadyExistException
     */
    public User create(User user){
        if (userRepository.existsByEmail(user.getEmail())) {
            log.error("Пользователь с таким Email '{}' уже существует", user.getEmail());
            throw new UserAlreadyExistException("Пользователь с таким Email уже существует");
        }
        return save(user);
    }

    /**
     *
     * @param email
     * @return Пользователь
     * @throws UserNotFoundException
     */
    public User getByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Пользователь с таким email не найден"));
    }
    public User getById(String id){
        return userRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new UserNotFoundException("Пользователь с таким id не найден"));
    }
    /**
     * Получение пользователя по имени **для Spring Security**
     * @return
     */
    public UserDetailsService userDetailsService(){
        return this::getById;
    }
}
