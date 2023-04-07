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
import team.project.foodsparks.service.CuisineRegionService;
import team.project.foodsparks.service.DishTypeService;
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
    private final DishTypeService dishTypeService;
    private final CuisineRegionService cuisineRegionService;

    @Autowired
    public DataInitializer(RoleService roleService,
                           RecipeService recipeService,
                           GenderService genderService,
                           ProductService productService,
                           DishTypeService dishTypeService,
                           CuisineRegionService cuisineRegionService) {
        this.roleService = roleService;
        this.recipeService = recipeService;
        this.productService = productService;
        this.genderService = genderService;
        this.dishTypeService = dishTypeService;
        this.cuisineRegionService = cuisineRegionService;
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

        List<List<String>> instructionsList = new ArrayList<>();
        List<String> instr1 = List.of("Налити велику каструлю води і додати свинину і варити "
                        + "протягом 30 хвилин на середньому вогні.",
                "Додати порізану картоплю, нарізану цибулю, нашатирний часник, нарізану моркву "
                        + "і варити ще 20 хвилин.",
                "Додати буряк, нарізаний перець, нарізаний томат, сіль, перець і варити "
                        + "протягом 15 хвилин.",
                "Додати нарізану капусту і варити ще 10 хвилин.",
                "Додати нарізані зелені (кріп, петрушку, коріандр) і готувати ще 5 хвилин.",
                "Додати лимонний сік та відключити вогонь.",
                "Дати борщу настоятися протягом 15 хвилин.",
                "Подаємо гарячим, зверху можна додати ложку сметани та підсмажені на салі "
                        + "кубики свинини.");
        List<String> inst2 = List.of("Нагріти духовку до 180 градусів Цельсія.",
                "Очистити гриби і нарізати на тонкі пластинки.",
                "Нарізати цибулю та часник і обсмажити на сковороді з розігрітим олією "
                        + "протягом 3-5 хвилин.",
                "Додати нарізані гриби, сіль, перець і готувати протягом 5-7 хвилин.",
                "Розрізати свинину на куски товщиною близько 2 см.",
                "Перемішати гриби з цибулею та часником, додати невелику кількість тертого сиру "
                        + "та розподілити суміш на кожен кусок свинини.",
                "Згорнути куски свинини в рулет і зафіксувати дерев'яними шпажками.",
                "Покласти рулети в запікальну форму і покрити фольгою.",
                "Печемо в духовці при 180 градусах Цельсія протягом 40-45 хвилин.",
                "Видаляємо фольгу та печемо ще 10 хвилин, щоб печінка зарум'янилася.",
                "Дати печені трохи охолонути, видалити шпажки і нарізати на шматочки.",
                "Подаємо гарячим з гарніром та свіжою зеленню на вершині.");
        List<String> inst3 = List.of("У великій мисці змішати творог, яйця, цукор та сіль. "
                        + "Змішувати, доки суміш не стане гладкою.",
                "Додайте муку та розподіліть її по суміші, змішуючи, поки не отримаєте однорідну "
                        + "масу.",
                "Сформуйте невеликі кульки з маси розміром близько 5 см в діаметрі.",
                "Розігрійте сковороду на середньому вогні з невеликою кількістю олії.",
                "Покладіть сирники на сковороду та обсмажуйте з обох сторін до золотистого "
                        + "кольору.",
                "Готові сирники можна подавати гарячими з медом, джемом або сметаною.");
        List<String> inst4 = List.of("Отримайте миску з глибоким дном та налейте воду. "
                        + "Доведіть воду до кипіння.",
                "У міжчасі очистіть капусту від листя та знять верхівку з кожної головки. "
                        + "Розділіть кожну головку на окремі листя.",
                "Покладіть капустні листя в киплячу воду та варіть їх протягом 2-3 хвилин, "
                        + "поки вони не стануть м'якими.",
                "Покладіть листя на тарілку, щоб вони остигли.",
                "У іншій мисці змішайте фарш, рис, яйця, цибулю та сіль.",
                "Візьміть капустні листя та покладіть на них приблизно 2 столові ложки фаршу. "
                        + "Згорніть листа, починаючи з верхньої частини, потім з боків і "
                        + "закінчуючи нижньою частиною. Зробіть це для кожного листа.",
                "Візьміть каструлю з глибоким дном та покладіть голубці в каструлю. "
                        + "Додайте до каструлі томатний соус та достатньо води, щоб повністю "
                        + "покрити голубці.",
                "Поставте каструлю на плиту та доведіть її до кипіння. Потім зменшіть вогонь "
                        + "та дайте голубцям смажитися протягом 40-45 хвилин.",
                "Готові голубці можна подавати на стіл окремо або з додаванням "
                        + "сметани або соусу.");
        instructionsList.add(instr1);
        instructionsList.add(inst2);
        instructionsList.add(inst3);
        instructionsList.add(inst4);

        List<CuisineRegion> cuisineRegionList = new ArrayList<>();
        List<CuisineRegion.CuisineRegionName> listCuisineRegionNames =
                List.of(
                        CuisineRegion.CuisineRegionName.SLOBOZHANSKA,
                        CuisineRegion.CuisineRegionName.ZAPORIZKA,
                        CuisineRegion.CuisineRegionName.BYKOVINSKA,
                        CuisineRegion.CuisineRegionName.GALYCKA,
                        CuisineRegion.CuisineRegionName.KRYMSKA,
                        CuisineRegion.CuisineRegionName.ODESKA,
                        CuisineRegion.CuisineRegionName.NADDNIPRIANSKA,
                        CuisineRegion.CuisineRegionName.PODILSKA,
                        CuisineRegion.CuisineRegionName.POLISKA,
                        CuisineRegion.CuisineRegionName.VOLYNSKA,
                        CuisineRegion.CuisineRegionName.ZAKARPATSKA);
        CuisineRegion cuisineRegion;
        for (CuisineRegion.CuisineRegionName cuisineRegionName : listCuisineRegionNames) {
            cuisineRegion = new CuisineRegion();
            cuisineRegion.setCuisineRegionName(cuisineRegionName);
            cuisineRegionService.add(cuisineRegion);
            cuisineRegionList.add(cuisineRegion);
        }

        List<DishType> dishTypesList = new ArrayList<>();
        List<DishType.DishTypeName> listDishTypeNames = List.of(
                DishType.DishTypeName.PASTRY, DishType.DishTypeName.SOUP,
                DishType.DishTypeName.DESSERT, DishType.DishTypeName.APPETIZER,
                DishType.DishTypeName.MAIN_DISH);
        DishType dishType;
        for (DishType.DishTypeName dishTypeName : listDishTypeNames) {
            dishType = new DishType();
            dishType.setDishTypeName(dishTypeName);
            dishTypeService.add(dishType);
            dishTypesList.add(dishType);
        }

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
