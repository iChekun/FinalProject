package by.epam.chekun.dao.impl.order;

final class OrderSqlUtil {
    private OrderSqlUtil() {
    }

    //////////////////////////////////////////////////////////

    // мы с  параметра получим
    // ид юзера ид выбранного способа оплаты и статус заказа установится сам в опен
    //далее админ сам сможет изменить статус заказа
    // cost посчитываем

    static final String GET_ORDER_BY_ID =
            " select o.orderId,o.userId, o.paymentMethodId, pm.name, " +
                    "o.orderStatusId, os.name, " +
                    "o.cost, o.orderDate " +
                    "from orders o  " +
                    " INNER JOIN " +
                    "    paymentmethods pm ON pm.paymentMethodId = o.paymentMethodId " +
                    "    INNER JOIN  " +
                    "    orderstatus os on os.orderStatusId = o.orderStatusId " +
                    " where o.orderId = ? ";

    static final String ADD_NEW_ORDER =
            "INSERT INTO orders(orderId,userId,paymentMethodId,orderStatusId,cost,orderDate)" +
                    " VALUES( ? , ? , ? , ? , ? , ?)";

    static final String REMOVE_ORDER_BY_ID = "DELETE FROM Orders WHERE orderId=?";

    //////////////////////////////////////////////////////////

    static final String ADD_PRODUCTS_TO_ORDER =
            "   insert into orderproducts(orderId,  productId)  " +
                    "  select o.orderId, pb.productId from Orders o, baskets b  " +
                    "  inner join productsbasket pb on pb.basketId = b.basketId " +
                    "  where o.orderId = ? " +
                    "  and b.userId = ? ";


    static final String GET_UUID_FOR_ORDER =
            "SELECT UUID()";

    static final String GET_ALL_ORDERS_BY_USER_ID =
            " select o.orderId,o.userId, o.paymentMethodId, pm.name, " +
                    "o.orderStatusId, os.name, " +
                    "o.cost, o.orderDate " +
                    "from orders o  " +
                    " INNER JOIN " +
                    "    paymentmethods pm ON pm.paymentMethodId = o.paymentMethodId " +
                    "    INNER JOIN  " +
                    "    orderstatus os on os.orderStatusId = o.orderStatusId " +
                    "   where userId = ? ";

    static final String GET_ALL_ORDERS =
            " select o.orderId,o.userId,o.paymentMethodId, " +
                    "    o.orderStatusId,o.cost,o.orderDate " +
                    "    from orders o";


    static final String GET_USER_ORDERS_COUNT =
            "Select count(orderId) from orders where userId = ? ";

    static final String GET_ALL_PRODUCT_FROM_ORDER =
            "   SELECT     o.orderId, " +
                    "                   o.paymentMethodId, pm.name, " +
                    "                       o.orderStatusId,  os.name,  " +
                    "                    o.cost, o.orderDate,  " +
                    "                        p.productId, p.name, p.description, p.imagePath, p.cost, " +
                    "                     b.brandId,   b.name, b.description , b.imagePath,  " +
                    "                     c.categoryId, c.name, c.description, c.imagePath " +
                    "                    FROM " +
                    "                       orders o " +
                    "                           INNER JOIN  " +
                    "                        paymentmethods pm ON pm.paymentMethodId = o.paymentMethodId  " +
                    "                        INNER JOIN  " +
                    "                        orderstatus os on os.orderStatusId = o.orderStatusId" +
                    "  INNER JOIN  " +
                    "                       orderproducts op on op.orderId = o.orderId " +
                    "                        INNER JOIN " +
                    "                        products p on p.productId = op.productId " +
                    "                          LEFT JOIN " +
                    "                        productbrands pb ON pb.productId = p.productId " +
                    "                            LEFT JOIN " +
                    "                        productсategories pc ON pc.productId = p.productId " +
                    "                            LEFT JOIN " +
                    "                        brands b ON b.brandId = pb.brandId  " +
                    "                            LEFT JOIN " +
                    "                        categories c ON c.categoryId = pc.categoryId  " +
                    "                       WHERE o.orderId =  ? ; ";


    static final String UPDATE_ORDER_STATUS = "UPDATE orders SET orderStatusId=? where orderId=? ";
}
