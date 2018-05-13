package app.product_shop;

import app.product_shop.dtos.CategoryDto;
import app.product_shop.dtos.ProductDto;
import app.product_shop.dtos.ProductWithSellerDto;
import app.product_shop.dtos.UserDto;
import app.product_shop.entities.Category;
import app.product_shop.entities.Product;
import app.product_shop.entities.User;
import app.product_shop.repositories.CategoryRepository;
import app.product_shop.repositories.ProductRepository;
import app.product_shop.repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Autowired
    public ConsoleRunner(CategoryRepository categoryRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        //Parsing JSON's
        ModelMapper mapper = new ModelMapper();
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();

//        parseCategories(mapper, gson);
//        parseUsers(mapper, gson);
//        parseProducts(mapper, gson);

        //Problem 2:Querying
        //-- Problem 2.1: Products In Range
        List<Product> products =
                this.productRepository.
                        findByPriceBetweenAndBuyerIsNullOrderByPrice(new BigDecimal(500), new BigDecimal(1000));


        //TODO Create Mapping with MapConverter - Converting Properties
//        TypeMap<Product, ProductWithSellerDto> typeMap = mapper.createTypeMap(Product.class, ProductWithSellerDto.class)
//                .addMapping(src ->
//                        (src.getSeller().getFirstName() == null ? "" :
//                                src.getSeller().getFirstName() + " ")
//                                + src.getSeller().getLastName(), ProductWithSellerDto::setSellerName);
//
////        ProductWithSellerDto pws = mapper.map(products.get(0), ProductWithSellerDto.class);

//        ProductWithSellerDto pws = mapper.addMappings(products.get(0), ProductWithSellerDto.class);

        List<ProductWithSellerDto> pws = products
                .stream()
                .map(ProductWithSellerDto::new)
                .collect(Collectors.toList());

        System.out.println(gson.toJson(pws));


        //-- Problem 2.2: Successfully Sold Products

        List<User> users = this.userRepository.getAllSellers();
        System.out.println("###########" + users.get(0).getLastName());
        System.out.println("###########" + users.get(0).getId());

    }


    private void parseCategories(ModelMapper mapper, Gson gson) throws FileNotFoundException {
        CategoryDto[] categoryDtos = gson.fromJson(new FileReader("C:\\Users\\valch\\Desktop\\Java DB Projects\\02. Databases Frameworks - Hibernate & Spring Data - March 2018\\11. 2. DB-Advanced-JSON-Processing-Exercises\\product_shop\\src\\main\\resources\\data\\categories.json"), CategoryDto[].class);


        List<Category> categories = new ArrayList<>();
        for (CategoryDto categoryDto : categoryDtos) {
            Category category = mapper.map(categoryDto, Category.class);
            categories.add(category);
        }

        this.categoryRepository.saveAll(categories);
    }

    private void parseProducts(ModelMapper mapper, Gson gson) throws FileNotFoundException {
        ProductDto[] productDtos = gson.fromJson(new FileReader("C:\\Users\\valch\\Desktop\\Java DB Projects\\02. Databases Frameworks - Hibernate & Spring Data - March 2018\\11. 2. DB-Advanced-JSON-Processing-Exercises\\product_shop\\src\\main\\resources\\data\\products.json"), ProductDto[].class);

        List<User> allUsers = (List<User>) this.userRepository.findAll();

        Random random = new Random();
        List<Product> products = new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            Product product = mapper.map(productDto, Product.class);
            int i = random.nextInt(allUsers.size());
            product.setSeller(allUsers.get(i));
            products.add(product);
        }

        this.productRepository.saveAll(products);
    }

    private void parseUsers(ModelMapper mapper, Gson gson) throws FileNotFoundException {
        UserDto[] userDtos = gson.fromJson(new FileReader("C:\\Users\\valch\\Desktop\\Java DB Projects\\02. Databases Frameworks - Hibernate & Spring Data - March 2018\\11. 2. DB-Advanced-JSON-Processing-Exercises\\product_shop\\src\\main\\resources\\data\\users.json"), UserDto[].class);


        List<User> users = new ArrayList<>();
        for (UserDto userDto : userDtos) {
            User user = mapper.map(userDto, User.class);
            users.add(user);
        }

        this.userRepository.saveAll(users);
    }
}
