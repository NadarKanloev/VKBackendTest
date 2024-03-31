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

![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/6c1a714b-bfaa-421f-8618-9780121932c1)
Создание пользователя с уже существующим в БД адресом электронной почты

![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/955bbd72-c7d3-495a-a47e-cedc10eedf98)
Попытка создать пользователя с слишком коротким паролем

![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/07c1b7ce-cbb1-40b0-8ba5-11f6fbdfbb0d)
Попытка создать пользователя со слабым паролем

![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/53d3bb53-fa9c-4b1b-985d-99e872dce1d7)
Вход в систему

![Снимок экрана 2024-03-31 000115](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/528debe1-61d9-4983-9e9d-9d62bd53f2c0)
Данные в токене

![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/ad08ff4a-f90e-4be4-9a1f-6cf24887272b)
Вход в `/feed` с токеном
