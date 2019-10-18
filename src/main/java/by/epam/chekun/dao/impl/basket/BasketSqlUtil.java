package by.epam.chekun.dao.impl.basket;

final class BasketSqlUtil {

    ///////////////////////////////////////////////////////////////////////////
    // BASKET TABLE


    static final String CREATE_BASKET =
            "INSERT IGNORE INTO baskets(basketId, userId) VALUES (UUID(), ?)";

    static final String GET_BASKET_BY_USER_ID =
            "SELECT basketId,userId FROM baskets WHERE userId=?";

    static final String DELETE_ALL_PRODUCTS_FROM_BASKET =
            "DELETE FROM productsbasket WHERE basketId=?";

    static final String DELETE_BASKET =
            " DELETE FROM baskets WHERE basketId = ? ";

    ///////////////////////////////////////////////////////////////////////////
    //PRODUCT BASKET TABLE


    static final String ADD_PRODUCT_TO_BASKET =
            "   insert into productsbasket(basketId,productId) " +
                    "  select b.basketId , p.productId from baskets b, products p " +
                    "  where b.userId = ? and p.productId=? ";
//            "INSERT INTO productsbasket (basketId,productId) VALUES(?,?)";

    static final String GET_ALL_PRODUCTS_IN_BASKET =
            " SELECT  " +
                    "    p.productId, p.name,  p.description,  p.imagePath , p.cost," +
                    "    b.brandId,    b.name, b.description, b.imagePath, " +
                    "    c.categoryId, c.name, c.description, c.imagePath, " +
                    " bas.basketId, bas.userId " +
                    "  FROM baskets bas " +
                    " inner join productsbasket pbas on pbas.basketId = bas.basketId " +
                    " left join products p on p.productId = pbas.productId " +
                    " left join productсategories pc on pc.productId = p.productId " +
                    " left join categories c on c.categoryId = pc.categoryId" +
                    "  left join productbrands pb on pb.productId = p.productId" +
                    "  left join brands b on b.brandId = pb.brandId" +
                    "  WHERE bas.userId = ? ";

//    static final String DELETE_PRODUCT_FROM_BASKET_COMMAND =
//            "DELETE FROM productsbasket WHERE basketId=? AND productId=?";

    static final String DELETE_PRODUCT_FROM_BASKET =
            "DELETE FROM productsbasket WHERE basketId = ? AND productId=?";

    static final String GET_COST_OF_PRODUCTS_IN_BASKET =
            "SELECT SUM(p.cost) from baskets b " +
                    " INNER JOIN productsbasket pb ON pb.basketId=b.basketId " +
                    " INNER JOIN products p ON p.productId=pb.productId " +
                    " WHERE userId=?";

    static final String GET_COUNT_OF_PRODUCTS_IN_USER_BASKET =
            " select count(productId) from productsbasket " +
                    " where basketId=? ;";

}
