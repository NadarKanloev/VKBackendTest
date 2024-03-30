# Тестовое задание на стажировку в ВК

## Описание проекта

Данный проект представляет собой тестовое задание для поступления на стажировку в компанию ВК. Он разработан с использованием следующих технологий:

- Java
- Spring (Core, Data JPA, Security)
- PostgreSQL
- JWT (JSON Web Token)
- Docker

## Использование

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
![image](https://github.com/NadarKanloev/VKBackendTest/assets/44449982/4135c52b-1c71-435c-a6bb-858bb233b9ca)

