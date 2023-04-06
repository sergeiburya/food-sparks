package team.project.foodsparks.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.project.foodsparks.model.CuisineRegion;
import team.project.foodsparks.model.DishType;
import team.project.foodsparks.model.Gender;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.model.Role;
import team.project.foodsparks.service.GenderService;
import team.project.foodsparks.service.ProductService;
import team.project.foodsparks.service.RecipeService;
import team.project.foodsparks.service.RoleService;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final RecipeService recipeService;
    private final List<Product> savedProducts;
    private final ProductService productService;
    private final GenderService genderService;

    @Autowired
    public DataInitializer(RoleService roleService,
                           RecipeService recipeService,
                           GenderService genderService,
                           ProductService productService) {
        this.roleService = roleService;
        this.recipeService = recipeService;
        this.productService = productService;
        this.genderService = genderService;
        savedProducts = new ArrayList<>();
    }

    @PostConstruct
    void initRoles() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(adminRole);
        roleService.add(userRole);
        Gender genderMale = new Gender();
        genderMale.setGenderName(Gender.GenderName.MALE);
        Gender genderFemale = new Gender();
        genderFemale.setGenderName(Gender.GenderName.FEMALE);
        Gender genderOther = new Gender();
        genderOther.setGenderName(Gender.GenderName.OTHER);
        genderService.add(genderFemale);
        genderService.add(genderMale);
        genderService.add(genderOther);

        List<String> productNames = List.of(
                "Картопля", "Цибуля", "Морква", "Перець", "Томат", "Капуста", "Буряк", "Яйце",
                "Сало", "Свинина", "Говядина", "Куряче м'ясо", "Ковбаса", "Сир", "Сметана",
                "Фундук", "Ряжанка", "Масло", "Олія", "Часник", "Кріп", "Петрушка", "Кропива",
                "Шпинат", "Сухарі", "Хліб", "Борошно", "Яблуко", "Груша", "Вишня", "Смородина",
                "Малина", "Чорниця", "Шипшина", "Калина", "Печінка", "Горіхи", "Горіхова олія",
                "Горіхова паста", "Сухофрукти", "Сухі ягоди", "Грецький горіх", "Мигдаль", "Кефір",
                "Кедрові горішки", "Мак", "Родзинки", "Соняшникові насіння", "Гарбузові насіння",
                "Імбир", "Перець чилі", "Червоний перець", "Чорний перець", "Куркума", "Коріандр",
                "Кмин", "Пажитник", "Гірчиця", "Кетчуп", "Соєвий соус", "Бальзамічний оцет",
                "Яблучний оцет", "Винний оцет", "Цукор", "Мед", "Сироп");

        Random random = new Random();
        Product newProduct;
        for (String product : productNames) {
            newProduct = new Product();
            newProduct.setName(product);
            newProduct.setPrice(BigDecimal.valueOf(random.nextInt(150) + 20));
            newProduct.setAmountInPackage(random.nextInt(999));
            productService.add(newProduct);
            savedProducts.add(newProduct);
        }

        List<String> instructionsList = new ArrayList<>();
        instructionsList.add("1. Налити велику каструлю води і додати свинину і варити протягом 30"
                + " хвилин на середньому вогні.<br>2. Додати порізану картоплю, нарізану цибулю, "
                + "нашатирний часник, нарізану моркву і варити ще 20 хвилин.<br>3. Додати буряк, "
                + "нарізаний перець, нарізаний томат, сіль, перець і варити протягом 15 хвилин."
                + "<br>4. Додати нарізану капусту і варити ще 10 хвилин.<br>5. Додати нарізані "
                + "зелені (кріп, петрушку, коріандр) і готувати ще 5 хвилин.<br>6. Додати лимонний"
                + " сік та відключити вогонь.<br>7. Дати борщу настоятися протягом 15 хвилин."
                + "<br>8. Подаємо гарячим, зверху можна додати ложку сметани та підсмажені на салі"
                + " кубики свинини.");
        instructionsList.add("1. Нагріти духовку до 180 градусів Цельсія.<br>2. Очистити гриби і "
                + "нарізати на тонкі пластинки.<br>3. Нарізати цибулю та часник і обсмажити на "
                + "сковороді з розігрітим олією протягом 3-5 хвилин.<br>4. Додати нарізані гриби, "
                + "сіль, перець і готувати протягом 5-7 хвилин.<br>5. Розрізати свинину на куски "
                + "товщиною близько 2 см.<br>6. Перемішати гриби з цибулею та часником, додати "
                + "невелику кількість тертого сиру та розподілити суміш на кожен кусок свинини."
                + "<br>7. Згорнути куски свинини в рулет і зафіксувати дерев'яними шпажками."
                + "<br>8. Покласти рулети в запікальну форму і покрити фольгою.<br>9. Печемо в "
                + "духовці при 180 градусах Цельсія протягом 40-45 хвилин.<br>10. Видаляємо фольгу "
                + "та печемо ще 10 хвилин, щоб печінка зарум'янилася.<br>11. Дати печені трохи "
                + "охолонути, видалити шпажки і нарізати на шматочки.<br>12. Подаємо гарячим з "
                + "гарніром та свіжою зеленню на вершині.");
        instructionsList.add("1. У великій мисці змішати творог, яйця, цукор та сіль. Змішувати, "
                + "доки суміш не стане гладкою.<br>2. Додайте муку та розподіліть її по суміші, "
                + "змішуючи, поки не отримаєте однорідну масу.<br>3. Сформуйте невеликі кульки з "
                + "маси розміром близько 5 см в діаметрі.<br>4. Розігрійте сковороду на середньому"
                + " вогні з невеликою кількістю олії.<br>5. Покладіть сирники на сковороду та "
                + "обсмажуйте з обох сторін до золотистого кольору.<br>6. Готові сирники можна "
                + "подавати гарячими з медом, джемом або сметаною.");
        instructionsList.add("1. Отримайте миску з глибоким дном та налейте воду. Доведіть воду "
                + "до кипіння.<br>2. У міжчасі очистіть капусту від листя та знять верхівку з "
                + "кожної головки. Розділіть кожну головку на окремі листя.<br>3. Покладіть "
                + "капустні листя в киплячу воду та варіть їх протягом 2-3 хвилин, поки вони не "
                + "стануть м'якими.<br>4. Покладіть листя на тарілку, щоб вони остигли.<br>5. У "
                + "іншій мисці змішайте фарш, рис, яйця, цибулю та сіль.<br>6. Візьміть капустні "
                + "листя та покладіть на них приблизно 2 столові ложки фаршу. Згорніть листа, "
                + "починаючи з верхньої частини, потім з боків і закінчуючи нижньою частиною. "
                + "Зробіть це для кожного листа.<br>7. Візьміть каструлю з глибоким дном та "
                + "покладіть голубці в каструлю. Додайте до каструлі томатний соус та достатньо "
                + "води, щоб повністю покрити голубці.<br>8. Поставте каструлю на плиту та "
                + "доведіть її до кипіння. Потім зменшіть вогонь та дайте голубцям смажитися "
                + "протягом 40-45 хвилин.<br>9. Готові голубці можна подавати на стіл окремо або "
                + "з додаванням сметани або соусу.");

        List<CuisineRegion> cuisineRegionList = new ArrayList<>();
        cuisineRegionList.add(CuisineRegion.EAST);
        cuisineRegionList.add(CuisineRegion.SOUTH);
        cuisineRegionList.add(CuisineRegion.WEST);
        cuisineRegionList.add(CuisineRegion.NORTH);

        List<DishType> dishTypesList = new ArrayList<>();
        dishTypesList.add(DishType.PASTRY);
        dishTypesList.add(DishType.SOUP);
        dishTypesList.add(DishType.DESSERT);
        dishTypesList.add(DishType.APPETIZER);
        dishTypesList.add(DishType.MAIN_DISH);

        List<String> imageUrlList = new ArrayList<>();
        imageUrlList.add("https://i.ibb.co/k0qrd5D/1-2.jpg");
        imageUrlList.add("https://i.ibb.co/HdzhjV0/2.jpg");
        imageUrlList.add("https://i.ibb.co/VJJqdvy/1.jpg");
        imageUrlList.add("https://i.ibb.co/mqq9Sj2/1-1.jpg");

        List<String> recipeNames = List.of(
                "Борщ", "Вареники", "Голубці", "Сало", "Сирники", "Деруни", "Ковбаса", "Картопляк",
                "Каша", "Плов", "Млинці", "Вареники з картоплею", "Пампушки", "Гречана каша",
                "Кутя", "Капуста по-корейськи", "Ковбаса в тісті", "Солянка", "Бульйон", "Шашлик",
                "Риба на пару", "Суп з гречкою", "Карпатський гуляш", "Кулебяка", "Плов з м’ясом",
                "Макарони з м’ясом", "Рататуй", "М’ясний салат", "Картопляний суп", "Суп-лапша",
                "Куряча грудка в горішках", "Телятина з овочами", "Бурштиновий суп", "Окрошка",
                "М’ясна запіканка", "Печена картопля", "Смажена курка", "Салат з куркою", "Оладки",
                "Сирники зі сметаною", "Курячий бульйон", "Картопляні зрази", "Курячі крильця",
                "Свинина з капустою", "Солянка з м’ясом", "Суп-гуляш", "Печені овочі", "Піцца",
                "Курячі ніжки з сухофруктами", "Салат з овочів", "Грибний суп", "Бульйон з м’ясом",
                "Ліниві вареники", "Печена курка", "Печені яйця", "Кремовий суп", "Теплі салати",
                "Закуски з грибів", "Печений гарбуз", "Рис з м’ясом", "Суп-харчо", "Суп-грибний",
                "Солянка з ковбасою", "Голубці з м’ясом", "Салат з селедкою", "Печена свинина",
                "Картопляне пюре", "Каша з грибами", "Капуста з м’ясом", "Печені курячі крила",
                "Салат з моркви", "Грибне рагу", "Картопляні деруни", "Ковбасні закуски",
                "Солянка з куркою", "Гарбузовий суп", "М’ясо по-французьки");

        Recipe newRec;
        for (String recipeName : recipeNames) {
            newRec = new Recipe();
            newRec.setDishName(recipeName);
            Map<Product, Double> productList = new HashMap<>();
            for (int i = 0; i <= random.nextInt(5) + 2; i++) {
                productList.put(savedProducts.get(random.nextInt(savedProducts.size())),
                        truncateTo(random.nextDouble() + 0.3d, 2));
            }
            newRec.setProductList(productList);
            newRec.setSpiced(random.nextBoolean());
            newRec.setCuisineRegion(cuisineRegionList
                    .get(random.nextInt(cuisineRegionList.size())));
            newRec.setDishType(dishTypesList.get(random.nextInt(dishTypesList.size())));
            newRec.setInstructions(instructionsList.get(random.nextInt(instructionsList.size())));
            newRec.setCookingTime(random.nextInt(180) + 5);
            newRec.setPortions(random.nextInt(6) + 2);
            newRec.setImageUrl(imageUrlList.get(random.nextInt(imageUrlList.size())));
            recipeService.save(newRec);
        }
    }

    static double truncateTo(double unroundedNumber, int decimalPlaces) {
        int truncatedNumberInt = (int) (unroundedNumber * Math.pow(10, decimalPlaces));
        double truncatedNumber = (double) (truncatedNumberInt / Math.pow(10, decimalPlaces));
        return truncatedNumber;
    }
}
