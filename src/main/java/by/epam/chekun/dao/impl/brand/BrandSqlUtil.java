package by.epam.chekun.dao.impl.brand;

final class BrandSqlUtil {



    ///////////////////////////////////////////////////////////////////////
    // SQL QUERY
    static final String ADD_NEW_BRAND = "INSERT INTO brands (brandId, name, description, imagePath) " +
            " VALUES (UUID(), ?, ?,?)";


    static final String GET_BRAND_ID_BY_NAME = "SELECT brandId from brands WHERE name=?";

    static final String GET_BRAND_BY_ID = "SELECT brandId, name, description, imagePath" +
            " from brands WHERE brandId=?";

    static final String UPDATE_BRAND = "UPDATE brands SET " +
            "    name=?, " +
            "    description= ?," +
            "    imagePath= ? " +
            "  WHERE brandId=?";

    static final String GET_ALL_BRANDS = "SELECT brandId, name, description, imagePath" +
            " from brands ";

    static final String DELETE_BRAND_BY_ID = "DELETE FROM brands WHERE brandId=?";
    ///////////////////////////////////////////////////////////////////////

    private BrandSqlUtil() {

    }
}
