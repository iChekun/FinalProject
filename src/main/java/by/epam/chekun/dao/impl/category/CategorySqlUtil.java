package by.epam.chekun.dao.impl.category;

final class CategorySqlUtil {

    ////////////////////////////////////////////////////////////////////////////
    /// sql query
    static final String ADD_NEW_CATEGORY =
            "INSERT INTO categories (categoryId, name, description, imagePath) " +
                    " VALUES (UUID(), ?, ?,?)";

    static final String GET_CATEGORY_ID_BY_NAME = "SELECT categoryId from categories WHERE name=?";

    static final String GET_CATEGORY_BY_ID = "SELECT categoryId, name, description, imagePath" +
            " from categories WHERE categoryId=?";

    static final String UPDATE_CATEGORY = "UPDATE categories SET " +
            "    name=?, " +
            "    description= ?," +
            "    imagePath= ? " +
            "  WHERE categoryId=? ";

    static final String GET_ALL_CATEGORIES = "SELECT categoryId, name, description, imagePath" +
            " from categories ";


    static final String DELETE_CATEGORY_BY_ID =
            "DELETE FROM categories  " +
                    " WHERE" +
                    "    categoryId = ?";

    ////////////////////////////////////////////////////////////////////////////
    private CategorySqlUtil() {

    }
}
