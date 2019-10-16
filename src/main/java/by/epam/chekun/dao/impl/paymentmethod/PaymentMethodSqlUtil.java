package by.epam.chekun.dao.impl.paymentmethod;

final class PaymentMethodSqlUtil {

    static final String ADD_NEW_PAYMENT_METHOD =
            "INSERT INTO paymentmethods(paymentMethodId, name) VALUES(UUID(),?)";

    static final String GET_ALL_PAYMENTS_METHOD =
            "SELECT paymentMethodId, name FROM paymentmethods";

    static final String GET_PAYMENT_METHOD_BY_ID =
            "SELECT paymentMethodId, name FROM paymentmethods " +
                    " where paymentMethodId = ? ";

    static final String UPDATE_PAYMENT_METHOD =
            "UPDATE paymentmethods SET = name ? WHERE paymentMethodId=? ";

    static final String REMOVE_PAYMENT_METHOD =
            "DELETE FROM paymentmethods WHERE paymentMethodId=?";

    ////////////////////////////////////////////////////////////////
    private PaymentMethodSqlUtil() {

    }

}
