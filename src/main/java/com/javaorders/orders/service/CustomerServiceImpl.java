package com.javaorders.orders.service;

import com.javaorders.orders.models.Customers;
import com.javaorders.orders.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "CustomerService")
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    private CustomerRepository custrepos;
    @Override
    public List<Customers> findAll() {
        List<Customers>list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomerByName(String name) {
        Customers customer = custrepos.findByName(name);
        //seems like findByName does not come by default in the Extended Crud Respository abstract class

        if (customer == null)
        {
            throw new EntityNotFoundException("Restaurant " + name + " not found");
        }
        return customer;

    }

    @Override
    public void delete(long custcode) {
        if(custrepos.findById(custcode).isPresent()){
            custrepos.deleteById(custcode);
        }
        else{
            throw new EntityNotFoundException(Long.toString(custcode));
        }


    }

    @Override
    public Customers save(Customers customer) {
        Customers newCustomer = new Customers();

        newCustomer.setName(customer.getName());
        newCustomer.setWorkingarea(customer.getCustcity());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPayment(customer.getPayment());

        newCustomer.setPhone(customer.getPhone());





        return custrepos.save(newCustomer);
    }

    @Override
    public Customers update(Customers customer, long custcode) {
        Customers currentCustomer = custrepos.findById(custcode)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(custcode)));

        if (customer.getName() != null)
        {
            currentCustomer.setName(customer.getName());
        }

        if (customer.getWorkingarea() != null)
        {
            currentCustomer.setWorkingarea(customer.getWorkingarea());
        }

        if (customer.getCustcountry() != null)
        {
            currentCustomer.setCustcountry(customer.getCustcountry());
        }

        if (customer.getGrade() != null)
        {
            currentCustomer.setGrade(customer.getGrade());
        }

        if (customer.getOpeningamt() != null)
        {
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }

        if (customer.getReceiveamt() != null){
            currentCustomer.setReceiveamt(customer.getReceiveamt());

        }

        if (customer.getPayment() !=null){
            currentCustomer.setPayment(customer.getPayment());
        }

        if (customer.getPhone() != null){
            currentCustomer.setPhone(customer.getPhone());
        }

        return custrepos.save(currentCustomer);

    }
}
