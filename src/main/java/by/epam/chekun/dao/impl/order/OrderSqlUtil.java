package by.epam.chekun.dao.impl.order;

final class OrderSqlUtil {
    private OrderSqlUtil() {
    }

    //////////////////////////////////////////////////////////

    static final String GET_ORDER_BY_ID =
            " select o.orderId," +
                    " u.userId, s.userStatusId, u.login, u.name, u.surname, u.birthDate,  u.banned," +
                    " c.contactsId, c.email, c.phoneNumber, c.country, c.city," +
                    " c.street, c.houseNumber, c.apartmentNumber," +
                    "o.paymentMethodId, pm.name, " +
                    "o.orderStatusId, os.name, " +
                    "o.cost, o.orderDate " +
                    "from orders o  " +
                    " INNER JOIN" +
                    " users u ON u.userId = o.userId" +
                    " INNER JOIN" +
                    " UserStatus s ON s.userStatusId = u.userStatusId" +
                    " INNER JOIN" +
                    " Contacts c ON c.contactsId = u.contactsId" +
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
            " SELECT " +
                    " o.orderId," +
                    " o.userId,u.userStatusId,  u.login,u.name,u.surname," +
                    " u.birthDate,u.banned,c.contactsId,c.email,c.phoneNumber,c.country," +
                    " c.city,c.street,c.houseNumber,c.apartmentNumber," +
                    " o.paymentMethodId, pm.name," +
                    " o.orderStatusId," +
                    " os.name," +
                    " o.cost," +
                    " o.orderDate" +
                    " FROM" +
                    " orders o" +
                    " INNER JOIN" +
                    " users u ON u.userId = o.userId" +
                    " INNER JOIN" +
                    " UserStatus s ON s.userStatusId = u.userStatusId" +
                    " INNER JOIN" +
                    " Contacts c ON c.contactsId = u.contactsId" +
                    " INNER JOIN" +
                    " paymentmethods pm ON pm.paymentMethodId = o.paymentMethodId" +
                    " INNER JOIN" +
                    " orderstatus os ON os.orderStatusId = o.orderStatusId" +
                    " WHERE" +
                    " o.userId = ?";

    static final String GET_ALL_ORDERS =
            " SELECT " +
                    " o.orderId," +
                    " o.userId,u.userStatusId,  u.login,u.name,u.surname," +
                    " u.birthDate,u.banned,c.contactsId,c.email,c.phoneNumber,c.country," +
                    " c.city,c.street,c.houseNumber,c.apartmentNumber," +
                    " o.paymentMethodId, pm.name," +
                    " o.orderStatusId," +
                    " os.name," +
                    " o.cost," +
                    " o.orderDate" +
                    " FROM" +
                    " orders o" +
                    " INNER JOIN" +
                    " users u ON u.userId = o.userId" +
                    " INNER JOIN" +
                    " UserStatus s ON s.userStatusId = u.userStatusId" +
                    " INNER JOIN" +
                    " Contacts c ON c.contactsId = u.contactsId" +
                    " INNER JOIN" +
                    " paymentmethods pm ON pm.paymentMethodId = o.paymentMethodId" +
                    " INNER JOIN" +
                    " orderstatus os ON os.orderStatusId = o.orderStatusId";


    static final String GET_USER_ORDERS_COUNT =
            "Select count(orderId) from orders where userId = ? ";

    static final String GET_ALL_PRODUCT_FROM_ORDER =
            "     SELECT" +
                    " o.orderId," +
                    " u.userId, s.userStatusId, u.login, u.name, u.surname, u.birthDate,  u.banned," +
                    " cont.contactsId, cont.email, cont.phoneNumber, cont.country, cont.city," +
                    " cont.street, cont.houseNumber, cont.apartmentNumber," +
                    " o.paymentMethodId," +
                    " pm.name," +
                    " o.orderStatusId, os.name," +
                    " o.cost, o.orderDate," +
                    " p.productId,    p.name,p.description,p.imagePath,p.cost," +
                    " b.brandId,b.name,b.description,b.imagePath," +
                    " c.categoryId,c.name,c.description,c.imagePath" +
                    " FROM" +
                    " orders o" +
                    " INNER JOIN" +
                    " users u ON u.userId = o.userId" +
                    " INNER JOIN" +
                    " UserStatus s ON s.userStatusId = u.userStatusId" +
                    " INNER JOIN" +
                    " Contacts cont ON cont.contactsId = u.contactsId" +
                    " INNER JOIN" +
                    " paymentmethods pm ON pm.paymentMethodId = o.paymentMethodId" +
                    " INNER JOIN" +
                    " orderstatus os ON os.orderStatusId = o.orderStatusId" +
                    " INNER JOIN" +
                    " orderproducts op ON op.orderId = o.orderId" +
                    " INNER JOIN" +
                    " products p ON p.productId = op.productId" +
                    " LEFT JOIN" +
                    " productbrands pb ON pb.productId = p.productId" +
                    " LEFT JOIN" +
                    " productсategories pc ON pc.productId = p.productId" +
                    " LEFT JOIN" +
                    " brands b ON b.brandId = pb.brandId" +
                    " LEFT JOIN" +
                    " categories c ON c.categoryId = pc.categoryId" +
                    " WHERE" +
                    " o.orderId = ?;";


    static final String UPDATE_ORDER_STATUS = "UPDATE orders SET orderStatusId=? where orderId=? ";
}
