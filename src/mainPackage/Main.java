package mainPackage;

public class Main {
    // Конструктор класса отсутствует!!!
    // Главный метод главного класса
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[args.length];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int itemsSoFar = 0;
        for (String arg: args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
// У сыра дополнительных параметров нет
                breakfast[itemsSoFar] = new Cheese();
            } else
            if (parts[0].equals("Apple")) {
// У яблока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Apple(parts[1]);
            } else
            if(parts[0].equals("Tea")) {
                breakfast[itemsSoFar] = new Tea(parts[1]);
            }
// ... Продолжается анализ других продуктов для завтрака
            itemsSoFar++;
        }
// Перебор всех элементов массива
        for (Food item: breakfast)
            if (item!=null)
// Если элемент не null – употребить продукт
                item.consume();
            else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                break;

        Food food = new Tea("черный");
        System.out.println(food + ": " + countFoods(breakfast, food));//считает сколько раз был выпит черный чай
        printFoods(breakfast);//функция для подсчета продукта
        System.out.println("Всего хорошего!");
    }

    static Integer countFoods(Food[] breakfast, Food food) {
        Integer count = 0;
        for(int i = 0; i < breakfast.length; i++) {
            if(food.equals(breakfast[i]))
            {
                count++;
            }
        }
        return count;
    }

    static void printFoods(Food[] breakfast){
        int c = 0;
        int a = 0;
        int p = 0;
        for(int i = 0; i < breakfast.length; i++) { //сколько раз были употреблены все продукты

            if(breakfast[i] instanceof Cheese){
                c++;
            }
            else if (breakfast[i] instanceof Apple){
                a++;
            }
            else if (breakfast[i] instanceof Tea){
                p++;
            }
        }
        System.out.println("CЫР - " + c);
        System.out.println("ЯБЛОКО - " + a);
        System.out.println("ЧАЙ - " + p);
    }
}
