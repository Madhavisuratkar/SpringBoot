//package com.programmingtechie.product_service;
//
//import com.programmingtechie.product_service.entity.Product;
//import com.programmingtechie.product_service.repository.ProductRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import java.math.BigDecimal;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@Testcontainers
//class ProductServiceApplicationTests {
//
//    @Container
//    static PostgreSQLContainer<?> postgresDBContainer = new PostgreSQLContainer<>("postgres:15-alpine")
//            .withDatabaseName("testdb")
//            .withUsername("testuser")
//            .withPassword("password");
//
//    @DynamicPropertySource
//    static void setProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgresDBContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", postgresDBContainer::getUsername);
//        registry.add("spring.datasource.password", postgresDBContainer::getPassword);
//    }
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Test
//    void contextLoads() {
//        // Test to ensure the Spring context loads properly
//        assertThat(productRepository).isNotNull();
//    }
//
//    @Test
//    void testSaveProduct() {
//        // Create a new product
//        Product product = new Product();
//        product.setName("Sample Product");
//        product.setDescription("A sample product description.");
//        product.setPrice(BigDecimal.valueOf(199.99));
//
//        // Save the product in the repository
//        Product savedProduct = productRepository.save(product);
//
//        // Verify the product is saved
//        assertThat(savedProduct).isNotNull();
//        assertThat(savedProduct.getId()).isNotNull(); // Checks that the ID is auto-generated and not null
//        assertThat(savedProduct.getName()).isEqualTo("Sample Product");
//        assertThat(savedProduct.getDescription()).isEqualTo("A sample product description.");
//        assertThat(savedProduct.getPrice()).isEqualTo(BigDecimal.valueOf(199.99));
//    }
////
////    @Test
////    void testFindAllProducts() {
////        // Create and save a product
////        Product product = new Product();
////        product.setName("Test Product");
////        product.setDescription("A test product description.");
////        product.setPrice(BigDecimal.valueOf(149.99));
////        productRepository.save(product);
////
////        // Find all products in the repository
////        Iterable<Product> products = productRepository.findAll();
////
////        // Verify that at least one product exists
////        assertThat(products).isNotEmpty();
////    }
////
////    @Test
////    void testDeleteProduct() {
////        // Create and save a product
////        Product product = new Product();
////        product.setName("Delete Product");
////        product.setDescription("This product will be deleted.");
////        product.setPrice(BigDecimal.valueOf(99.99));
////        Product savedProduct = productRepository.save(product);
////
////        // Delete the product by ID
////        productRepository.deleteById(savedProduct.getId());
////
////        // Verify that the product no longer exists
////        assertThat(productRepository.findById(savedProduct.getId())).isEmpty();
////    }
//}
