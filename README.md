# Kotlin_crud
проблемы сущности на приведенном скрине
# id nullable - так нельзя, так как primary key не может быть null
# id без генерации
# UUID для ID излишен (по крайней мере в реальности я ни разу не видел, чтобы применяли UUID вместо Long), он весит очень много и мешает нормальной ориентации в бд
# documentDate - строка, должен быть Date
# val поля с null должны быть var так как их необходимо заполнять после инициализации (по факту ключи - val, остальное - var)
# две переменные в блоке инициализации, а не конструктора

# нарушается нормализация, поэтому:
documentId - должен быть отдельной таблицей
dictionary - должен быть отдельной таблицей


# sortOrder - непонятно что это, зачем это

так же не уверен насчет необходимости объявлять как data class сущность







![image](https://user-images.githubusercontent.com/101064292/184719112-75e19d6f-ac0e-4090-9a3d-204521a1b8e3.png)

