package by.epam.chekun.dao.impl.paymentmethod;

import by.epam.chekun.dao.InitializerRepository;
import by.epam.chekun.dao.PaymentMethodRepository;
import by.epam.chekun.dao.core.exception.JdbcTemplateException;
import by.epam.chekun.dao.exception.paymentmethod.PaymentMethodDAOException;
import by.epam.chekun.dao.mapper.PaymentMethodRowMapper;
import by.epam.chekun.domain.entity.order.PaymentMethod;

import java.util.List;

import static by.epam.chekun.dao.impl.paymentmethod.PaymentMethodSqlUtil.*;

public class PaymentMethodSqlRepository extends InitializerRepository implements PaymentMethodRepository {

    @Override
    public PaymentMethod getEntityById(String id) throws PaymentMethodDAOException {
        try {
            final PaymentMethod paymentMethod = jdbcTemplate.queryForObject(GET_PAYMENT_METHOD_BY_ID,
                    new PaymentMethodRowMapper(), id);
            return paymentMethod;
        } catch (JdbcTemplateException e) {
            throw new PaymentMethodDAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) throws PaymentMethodDAOException {
        try {
            jdbcTemplate.update(REMOVE_PAYMENT_METHOD, id);
            return true;
        } catch (JdbcTemplateException e) {
            throw new PaymentMethodDAOException(e);
        }
    }

    @Override
    public boolean add(PaymentMethod paymentMethod) throws PaymentMethodDAOException {
        try {
            jdbcTemplate.update(ADD_NEW_PAYMENT_METHOD,
                    paymentMethod.getName());
            return true;
        } catch (JdbcTemplateException e) {
            throw new PaymentMethodDAOException(e);
        }
    }

    @Override
    public boolean update(PaymentMethod paymentMethod) throws PaymentMethodDAOException {
        try {
            jdbcTemplate.update(UPDATE_PAYMENT_METHOD, paymentMethod.getName(),
                    paymentMethod.getPaymentMethodId());
            return true;
        } catch (JdbcTemplateException e) {
            throw new PaymentMethodDAOException(e);
        }
    }

    @Override
    public List<PaymentMethod> getAll() throws PaymentMethodDAOException {
        try {
            final List<PaymentMethod> paymentMethods = jdbcTemplate.query(GET_ALL_PAYMENTS_METHOD,
                    new PaymentMethodRowMapper());
            return paymentMethods;
        } catch (JdbcTemplateException e) {
            throw new PaymentMethodDAOException(e);
        }
    }
}
