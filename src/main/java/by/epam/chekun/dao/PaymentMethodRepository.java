package by.epam.chekun.dao;

import by.epam.chekun.dao.exception.DAOException;
import by.epam.chekun.dao.exception.paymentmethod.PaymentMethodDAOException;
import by.epam.chekun.domain.entity.order.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod> {

    @Override
    PaymentMethod getEntityById(String id) throws PaymentMethodDAOException;

    @Override
    boolean removeById(String id) throws PaymentMethodDAOException;

    @Override
    boolean add(PaymentMethod paymentMethod) throws PaymentMethodDAOException;

    @Override
    boolean update(PaymentMethod paymentMethod) throws PaymentMethodDAOException;

    @Override
    List<PaymentMethod> getAll() throws PaymentMethodDAOException;


}
