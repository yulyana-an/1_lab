package mainPackage;

public class Tea extends Food {
    // Новое внутреннее поле данных РАЗМЕР
    private String size;
    public Tea(String size) {
// Вызвать конструктор предка, передав ему имя класса
        super("Чай");
// Инициализировать размер яблока
        this.size = size;
    }
    // Переопределить способ употребления яблока
    public void consume() {
        System.out.println(this + " выпит");
    }
    // Селектор для доступа к полю данных РАЗМЕР
    public String getSize() {
        return size;
    }
    // Модификатор для изменения поля данных РАЗМЕР
    public void setSize(String size) {
        this.size = size;
    }
    // Переопределѐнная версия метода equals(), которая при сравнении
// учитывает не только поле name (Шаг 1), но и проверяет совместимость
// типов (Шаг 2) и совпадение размеров (Шаг 3)
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Tea)) return false; // Шаг 2
            return size.equals(((Tea)arg0).size); // Шаг 3
        } else
            return false;
    }
    // Переопределѐнная версия метода toString(), возвращающая не только
// название продукта, но и его размер
    public String toString() {
        return super.toString() + " цвета '" + size.toUpperCase() + "'";
    }
}

