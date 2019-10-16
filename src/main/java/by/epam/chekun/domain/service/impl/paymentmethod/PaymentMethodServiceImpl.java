package by.epam.chekun.domain.service.impl.paymentmethod;

import by.epam.chekun.dao.PaymentMethodRepository;
import by.epam.chekun.dao.exception.paymentmethod.PaymentMethodDAOException;
import by.epam.chekun.dao.manager.DAOManager;
import by.epam.chekun.domain.entity.order.PaymentMethod;
import by.epam.chekun.domain.service.PaymentMethodService;
import by.epam.chekun.domain.service.exception.paymentmethod.InvalidPaymentMethodInformationException;
import by.epam.chekun.domain.service.exception.paymentmethod.PaymentMethodServiceException;
import by.epam.chekun.domain.util.builder.paymentmethod.impl.PaymentMethodBuilderImpl;
import by.epam.chekun.domain.util.manager.UtilManager;
import by.epam.chekun.domain.util.validator.paymentmethod.PaymentMethodValidator;

import java.util.List;

public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepostitory = DAOManager.getInstance().getPaymentMethodRepository();

    private final PaymentMethodValidator paymentMethodValidator = UtilManager.getInstance().getPaymentMethodValidator();

    @Override
    public void addNewPaymentMethod(String name) throws PaymentMethodServiceException {

        if (!paymentMethodValidator.validate(name)) {
            throw new InvalidPaymentMethodInformationException("Invalid paymentMethod info");
        }

        final PaymentMethod paymentMethod = new PaymentMethodBuilderImpl()
                .withName(name)
                .build();

        try {
            paymentMethodRepostitory.add(paymentMethod);
        } catch (PaymentMethodDAOException e) {
            throw new PaymentMethodServiceException(e);
        }
    }

    @Override
    public List<PaymentMethod> getAll() throws PaymentMethodServiceException {
        try {
            final List<PaymentMethod> paymentMethods = paymentMethodRepostitory.getAll();
            return paymentMethods;
        } catch (PaymentMethodDAOException e) {
            throw new PaymentMethodServiceException(e);
        }
    }

    @Override
    public void deletePaymentMethod(String paymentMethodId) throws PaymentMethodServiceException {
        try {
            paymentMethodRepostitory.removeById(paymentMethodId);
        } catch (PaymentMethodDAOException e) {
            throw new PaymentMethodServiceException(e);
        }
    }
}
