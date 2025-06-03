Запуск тестов через командную строку
Запуск всех тестов
.\gradlew clean test

Запуск смок тестов 
.\gradlew clean test -Pgroups=smoke

Запуск тестов по пользователю User
.\gradlew clean test -Pgroups=user

Запуск тестов по пользователю Admin
.\gradlew clean test -Pgroups=admin
