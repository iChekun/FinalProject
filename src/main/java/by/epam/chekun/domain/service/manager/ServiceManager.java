package by.epam.chekun.domain.service.manager;

import by.epam.chekun.domain.service.*;
import by.epam.chekun.domain.service.impl.basket.BasketServiceImpl;
import by.epam.chekun.domain.service.impl.brand.BrandServiceImpl;
import by.epam.chekun.domain.service.impl.category.CategoryServiceImpl;
import by.epam.chekun.domain.service.impl.order.OrderServiceImpl;
import by.epam.chekun.domain.service.impl.paymentmethod.PaymentMethodServiceImpl;
import by.epam.chekun.domain.service.impl.product.ProductServiceImpl;
import by.epam.chekun.domain.service.impl.user.UserServiceImpl;

public final class ServiceManager {
    private static final ServiceManager instance = new ServiceManager();

    public static ServiceManager getInstance() {
        return instance;
    }

    private ServiceManager() {
    }

    private final UserService userService = new UserServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final CategoryService categoryService = new CategoryServiceImpl();
    private final BrandService brandService = new BrandServiceImpl();
    private final BasketService basketService = new BasketServiceImpl();
    private final PaymentMethodService paymentMethodService = new PaymentMethodServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    public OrderService getOrderService() {
        return orderService;
    }

    public PaymentMethodService getPaymentMethodService() {
        return paymentMethodService;
    }

    public BasketService getBasketService() {
        return basketService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public BrandService getBrandService() {
        return brandService;
    }
}
