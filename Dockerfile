# Используйте как базовый образ OpenJDK
FROM openjdk:17

# Установите рабочую директорию внутри контейнера
WORKDIR /app

# Копируйте скомпилированные файлы приложения внутрь контейнера
COPY target/VKBackendTest-0.0.1-SNAPSHOT.jar /app

# Укажите команду для запуска вашего приложения при старте контейнера
CMD ["java", "-jar", "VKBackendTest-0.0.1-SNAPSHOT.jar"]