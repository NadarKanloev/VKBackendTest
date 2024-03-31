# Тестовое задание на стажировку в ВК

## Описание проекта

Данный проект представляет собой тестовое задание для поступления на стажировку в компанию ВК. Он разработан с использованием следующих технологий:

- Java
- Spring (Core, Data JPA, Security)
- PostgreSQL
- JWT (JSON Web Token)
- Docker

## Запуск

Для запуска проекта с использованием Docker-compose выполните следующие шаги:

1. Убедитесь, что у вас установлен Docker и Docker-compose.

2. Клонируйте репозиторий на свой компьютер:

```bash
git clone https://github.com/NadarKanloev/VKBackendTest
```
3. Зайдите в директорию проекта и используйте команду
```bash
docker-compose up
```
## [Ссылка на коллекцию запросов Postman](https://www.postman.com/restless-escape-517248/workspace/habraggreagot/collection/27427106-ad1282f3-58a6-4432-b60b-7a7a5596d186?action=share&creator=27427106)
## [Ссылка на образ программы в DockerHub](https://hub.docker.com/repository/docker/veventumt/vkbackendtest/general)

# Валидация пароля

Для валидации пароля используются следующие условия:

- Любой пароль, длина которого меньше 8 символов, триггерит исключение `WeakPasswordException`.
- Идеальный пароль - это пароль, который содержит хотя бы одну заглавную букву, одно число и один особый символ.
- Хороший пароль - это пароль, который удовлетворяет хотя бы одному из условий (заглавная буква, число или особый символ).
- Если пароль не удовлетворяет ни одному из условий, он также триггерит исключение `WeakPasswordException`.

# Валидация email

Для валидации email используется следующие условия:

- Любой email, который не содержит символ '@' или не имеет точки после символа '@', считается невалидным и триггерит исключение `NotValiEmailException`
- При попытке создания пользователя с email, который уже используется другим пользователем, триггерится исключение `UserAlreadyExist`.

# Демонстрация работы
![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/96b2ddbf-d86f-490f-9625-8f9f20b36528)
Создание пользователя с идеальным паролем

![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/520d51d1-8671-4e72-b13b-8da41c20a936)
Создание пользователя с уже существующим в БД адресом электронной почты

![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/c2fd792b-8b4b-4c0c-936c-aa469aa57712)
Попытка создать пользователя с слишком коротким паролем

![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/9efb1a8a-8adc-4e4c-96e7-9696289579a7)
Попытка создать пользователя со слабым паролем

![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/a1696102-3e2a-4f08-9787-9be228abb257)
Вход в систему

![Снимок экрана 2024-03-31 195415](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/76020367-7233-45f8-96fc-ff017255a358)
Данные в токене

![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/ad08ff4a-f90e-4be4-9a1f-6cf24887272b)
Вход в `/feed` с токеном
