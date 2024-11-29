# Используем официальный образ Ubuntu, поскольку onnx библиотека использует нативные методы
FROM ubuntu:20.04

RUN apt-get update && apt-get install -y openjdk-17-jdk maven && apt-get clean

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем pom.xml и другие файлы, необходимые для сборки
COPY  ./*.jar /app/*.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "/app/*.jar"]

# Открываем порт, на котором будет работать ваше приложение
EXPOSE 8080
