package kr.co.ch06.repository.shop.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.ch06.entity.shop.Customer;
import kr.co.ch06.entity.shop.QCustomer;
import kr.co.ch06.repository.shop.custom.CustomerRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

   private final JPAQueryFactory queryFactory; //config에서 수동으로 처리해야됨

    private QCustomer qCustomer = QCustomer.customer; // 싱글톤
    @Override
    public Customer selectCustomer(String custId) {


        return queryFactory.select(qCustomer)
                .from(qCustomer)
                .where(qCustomer.custId.eq(custId))
                .fetchOne();
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return queryFactory.selectFrom(qCustomer).fetch();
    }

    @Override
    public List<Customer> selectProjectionCustomer() {
        return queryFactory
                .select(
                        Projections.fields(
                                Customer.class,
                                qCustomer.custId,
                                qCustomer.name,
                                qCustomer.age
                        )
                )
                .from(qCustomer)
                .fetch();
    }
}
