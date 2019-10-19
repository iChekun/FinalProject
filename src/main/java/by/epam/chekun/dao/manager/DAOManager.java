package by.epam.chekun.dao.manager;

import by.epam.chekun.dao.*;
import by.epam.chekun.dao.impl.basket.BasketSqlRepository;
import by.epam.chekun.dao.impl.brand.BrandSqlRepository;
import by.epam.chekun.dao.impl.category.CategorySqlRepository;
import by.epam.chekun.dao.impl.contacts.ContactsSqlRepository;
import by.epam.chekun.dao.impl.order.OrderSqlRepository;
import by.epam.chekun.dao.impl.paymentmethod.PaymentMethodSqlRepository;
import by.epam.chekun.dao.impl.product.ProductSqlRepository;
import by.epam.chekun.dao.impl.user.UserSqlRepository;

public final class DAOManager {

    private static final DAOManager instance = new DAOManager();

    public static DAOManager getInstance() {
        return instance;
    }

    private DAOManager() {
    }

    private final ContactsRepository contactsRepository = new ContactsSqlRepository();
    private final UserRepository userRepository = new UserSqlRepository();
    private final CategoryRepository categoryRepository = new CategorySqlRepository();
    private final BrandRepository brandRepository = new BrandSqlRepository();
    private final ProductRepository productRepository = new ProductSqlRepository();
    private final PaymentMethodRepository paymentMethodRepository = new PaymentMethodSqlRepository();
    private final BasketRepository basketRepository = new BasketSqlRepository();
    private final OrderRepository orderRepository = new OrderSqlRepository();

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public BasketRepository getBasketRepository() {
        return basketRepository;
    }

    public PaymentMethodRepository getPaymentMethodRepository() {
        return paymentMethodRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public BrandRepository getBrandRepository() {
        return brandRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public ContactsRepository getContactsRepository() {
        return contactsRepository;
    }

}
