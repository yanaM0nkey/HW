package com.gmail.ioanna.myandroidapp.classwork15;


public class Sql {
    /*
    SELECT * FROM user //все данные из таблицы user
    SELECT id, name FROM user
    SELECT * FROM user WHERE countryId = 1
    SELECT * FROM user INNER JOIN country ON user.countryId = country.id //только если есть все совпадения
    SELECT * FROM user LEFT JOIN country ON user.countryId = country.id // если нет совпадения то справа заменит на null
    SELECT * FROM user RIGHT JOIN country ON user.countryId = country.id // если нет совпадения то слева заменит на null
    SELECT * FROM user LIMIT 20 //вернет первых 20 записей
    SELECT * FROM user LIMIT 20 OFFSET 20 // вернет записис с 20 до 40
    SELECT * FROM user ORDER BY age <ASC, DESC> //сортировка

    */
}
