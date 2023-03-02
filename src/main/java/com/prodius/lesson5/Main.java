package com.prodius.lesson5;

import com.prodius.lesson5.service.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/*
Реализовать три класса, Репозиторий, Сервис, Сообщение (текстовые поля отправителя и получателя)
В репозитории можно ничего не писать, он нам нужен для моков.

Методы сервиса:
1. Принимает отправителя и получателя, в случае пустого значение кидает ошибку, если все ок - сохраняет в репозиторий
(проверить исключения, сохранение и что именно сохранено)
2. Принимает число сообщений, в цикле идет в репозиторий и достает сообщение (проверить кол-во раз вызовов)
3. Принимает отправителя, репозиторий возвращает все сообщения данного пользователя, сервис считает кол-во и возвращает
 (мокируем поведение, проверяем результат),
4. Принимает получателя, считает длину строки, если длина более 5 символов то сохраняет в бд
 (проверяем сохранение и НЕ сохранение при разных условиях)
5. Метод генерирует случайное число, идет в базу с этим числом и находит сообщение и возвращает его,
изменив отправителя на "incognito" (проверяем вызов метода с неизвестным параметром и результат)
6. Метод принимает сообщение без отправителя, ищет в репозитории по сообщению совпадение, если такое есть -
 устанавливает отправителя, если нет - кидает ошибку (устанавливаем поведение через кастомный матчер, проверяем исключение и что метод не кинул исключение)
 */
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Random random = new Random();
        //1
        final String checkOfEmpty = String.valueOf(service.checkOfEmpty(RandomStringUtils.random(6), RandomStringUtils.random(6)));
        //2
        final String checkMassage = String.valueOf(service.checkMassage(3));
        System.out.println(checkMassage);
        //3
        final String checkSenderMassage = String.valueOf(service.checkSenderMassage());
        System.out.println(checkSenderMassage);
        //4
        final String checkReceiverCharacter = String.valueOf(service.checkReceiverCharacter());

    }
}
