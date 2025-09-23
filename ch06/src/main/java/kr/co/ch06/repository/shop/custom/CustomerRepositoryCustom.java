package kr.co.ch06.repository.shop.custom;

import kr.co.ch06.entity.shop.Customer;

import java.util.List;

// QueryDSL 을 사용하기 위한 CustomerRepository의 확장 인터페이스
public interface CustomerRepositoryCustom {

    // QueryDSL 작성 ? ;
    public Customer selectCustomer(String custId);
    public List<Customer> selectAllCustomer();
    public List<Customer> selectProjectionCustomer();


}
