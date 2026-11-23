# Winter Pulse Visuals

Клиентский Fabric-мод для Minecraft 1.21.4 на Java 21. Right Shift открывает минималистичное меню. В проекте есть лёгкое состояние China Hat, object pool для частиц и jump-circle анимация; рендер можно подключать через Fabric WorldRenderEvents без аллокаций в кадре.

## Сборка

```bash
./gradlew build
```

Готовый JAR находится в `build/libs/`. Установите Fabric Loader, Fabric API и Java 21.

## Производительность

Используйте один общий буфер рендера, ограничивайте число частиц, отключайте эффекты на слабых ПК и не создавайте объекты внутри render callbacks.
