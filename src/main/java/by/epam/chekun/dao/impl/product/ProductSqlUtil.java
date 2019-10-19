package by.epam.chekun.dao.impl.product;

final class ProductSqlUtil {


    //////////////////////////////////////////////////////////////////////////
    static final String ADD_NEW_PRODUCT = "INSERT INTO products " +
            " (productId, name, description, imagePath, cost) " +
            " VALUES (UUID(), ?, ?, ?, ?)";


    static final String GET_PRODUCT_BY_ID =
            "SELECT  " +
                    "    p.productId,p.name,p.description,p.imagePath,p.cost, " +
                    "    b.brandId,    b.name,b.description, b.imagePath, " +
                    "    c.categoryId, c.name, c.description, c.imagePath " +
                    " FROM" +
                    "    products p " +
                    "      LEFT     JOIN " +
                    "    productbrands pb ON pb.productId = p.productId " +
                    "     LEFT     JOIN " +
                    "    productсategories pc ON pc.productId = p.productId " +
                    "        LEFT  JOIN " +
                    "    brands b ON b.brandId = pb.brandId " +
                    "        LEFT  JOIN " +
                    "    categories c ON c.categoryId = pc.categoryId" +
                    " where p.productId = ?";


    static final String GET_ALL_PRODUCTS =
            "SELECT  " +
                    "    p.productId,p.name,p.description,p.imagePath,p.cost, " +
                    "    b.brandId,    b.name,b.description, b.imagePath, " +
                    "    c.categoryId, c.name, c.description, c.imagePath " +
                    " FROM" +
                    "    products p " +
                    "      LEFT     JOIN " +
                    "    productbrands pb ON pb.productId = p.productId " +
                    "     LEFT     JOIN " +
                    "    productсategories pc ON pc.productId = p.productId " +
                    "        LEFT  JOIN " +
                    "    brands b ON b.brandId = pb.brandId " +
                    "        LEFT  JOIN " +
                    "    categories c ON c.categoryId = pc.categoryId";

    static final String GET_PRODUCT_ID_BY_PRODUCT_INFO =
            " SELECT p.productId, p.name, p.description, p.imagePath, p.cost " +
                    " FROM Products p " +
                    " WHERE name=?" +
                    " AND description=?" +
                    " AND imagePath=?" +
                    " AND cost=?";


    static final String DELETE_PRODUCT_BY_ID =
            " DELETE FROM products  WHERE productId = ? ";

    static final String UPDATE_PRODUCT_BY_ID =
            " UPDATE products SET " +
                    " name=? ," +
                    " description=?, " +
                    " imagePath=?, " +
                    "  cost=?  " +
                    " WHERE productId=?";
    //////////////////////////////////////////////////////////////////////////
    /***SPESIFIC SQL**/

    static final String GET_ALL_WITH_CATEGORY =
            "  SELECT p.productId, p.name, p.description, p.imagePath, p.cost, " +
                    "     b.brandId,   b.name, b.description ,  b.imagePath,  " +
                    "    c.categoryId, c.name, c.description, c.imagePath " +
                    "   from  " +
                    "    productсategories pc " +
                    "   INNER JOIN " +
                    "   products p ON p.productId = pc.productId " +
                    "    INNER JOIN " +
                    "    categories c ON c.categoryId = pc.categoryId " +
                    "    INNER JOIN  " +
                    "    productbrands pb on pb.productId= p.productId " +
                    "      inner join brands b on b.brandId = pb.brandId " +
                    "        WHERE " +
                    "   pc.categoryId = ? ";

    static final String GET_ALL_WITH_BRAND =
            "  SELECT p.productId, p.name, p.description, p.imagePath, p.cost, " +
                    "     b.brandId,   b.name, b.description ,  b.imagePath,  n" +
                    "    c.categoryId, c.name, c.description, c." +
                    "   from  " +
                    "    productbrands pb " +
                    "   INNER JOIN " +
                    "   products p ON p.productId = pb.productId " +
                    "    INNER JOIN " +
                    "  inner join brands b on b.brandId = pb.brandId " +
                    "    INNER JOIN  " +
                    "    productсategories pc on pc.productId= p.productId " +
                    "    categories c ON c.categoryId = pc.categoryId  " +
                    "        WHERE " +
                    "   pb.brandId = ? ";
    //////////////////////////////////////////////////////////////////////////

    static final String GET_ALL_WITH_BRAND_AND_WITH_CATEGORY =
            " SELECT p.productId, p.name, p.description, p.imagePath, p.cost, " +
                    " b.brandId,   b.name, b.description ,  b.imagePath,  " +
                    " c.categoryId, c.name, c.description, c.imagePath " +
                    " FROM products p " +
                    "        INNER JOIN " +
                    "    productсategories pc ON pc.productId = p.productId " +
                    " AND pc.categoryId = ? " +
                    "        INNER JOIN " +
                    "    productbrands pb ON pb.productId = p.productId " +
                    " AND pb.brandId = ? " +
                    "        INNER JOIN " +
                    "    brands b ON b.brandId = pb.brandId " +
                    "        INNER JOIN " +
                    "    categories c ON c.categoryId = pc.categoryId ";


    static final String GET_ALL_GROUP_BY_NAME =
            " SELECT p.productId, p.name, p.description, p.imagePath, p.cost, " +
                    " b.brandId,   b.name, b.description,  b.imagePath,  " +
                    " c.categoryId, c.name, c.description, c.imagePath " +
                    " FROM products p " +
                    "        INNER JOIN " +
                    "    productbrands pb ON pb.productId = p.productId " +
                    "        INNER JOIN " +
                    "    productсategories pc ON pc.productId = p.productId " +
                    "        INNER JOIN " +
                    "    brands b ON b.brandId = pb.brandId " +
                    "        INNER JOIN " +
                    "    categories c ON c.categoryId = pc.categoryId " +
                    "  GROUP BY p.name";


    //////////////////////////////////////////////////////////////////////////

    static final String ADD_CATEGORY_TO_PRODUCT =
            " insert ignore into productсategories(productId, categoryId)" +
                    " select p.productId, c.categoryId from products p , categories c" +
                    " where p.name = ? " +
                    " and c.categoryId = ? ";
    static final String ADD_NULL_CATEGORY_TO_PRODUCT =
            " insert ignore into productсategories(productId, categoryId)" +
                    " select p.productId, null from products p " +
                    " where p.name = ? ";




    static final String UPDATE_PRODUCT_CATEGORY =
            "UPDATE productсategories SET categoryId = ? WHERE productId = ? ";


    //////////////////////////////////////////////////////////////////////////

    static final String ADD_NULL_BRAND_TO_PRODUCT =
            "insert into productbrands(productId, brandId) " +
                    " select p.productId, null from products p " +
                    " where p.name = ? ";


    static final String ADD_BRAND_TO_PRODUCT =
            " insert into productbrands(productId, brandId) " +
                    " select p.productId, b.brandId  from products p ,brands b " +
                    " where p.name = ? " +
                    " and b.brandId =?; ";


    static final String UPDATE_PRODUCT_BRAND =
            " UPDATE productbrands SET brandId = ? WHERE productId = ? ";

    //////////////////////////////////////////////////////////////////////////
    private ProductSqlUtil() {

    }

}
