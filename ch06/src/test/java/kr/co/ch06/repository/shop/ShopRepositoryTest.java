package kr.co.ch06.repository.shop;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.ch06.dto.ProductAggDTO;
import kr.co.ch06.entity.shop.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ShopRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test1(){
        Customer customer = customerRepository.selectCustomer("a105");
        System.out.println(customer);
    }

    @Test
    public void test2(){
        List<Customer> customerList = customerRepository.selectAllCustomer();
        System.out.println(customerList);
    }

    @Test
    public void test3(){
        List<Customer> customerList = customerRepository.selectProjectionCustomer();
        System.out.println(customerList);

    }

    @Autowired
    private JPAQueryFactory queryFactory;

    QCustomer qCustomer = QCustomer.customer;
    QOrder qOrder = QOrder.order;
    QOrderItem qOrderItem = QOrderItem.orderItem;
    QProduct qProduct = QProduct.product;

    @Test
    public void test4(){

        List<Customer> customerList = queryFactory
                    .selectFrom(qCustomer)
                    .where(qCustomer.name.eq("김유신"))
                    .fetch(); // 이름이 김유신인 데이터 조회 결과는 리스트
        System.out.println(customerList);


        // select * from Customer where name != "김유신";
        List<Customer> resultList = queryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.ne("김유신"))
                .fetch(); // 이름이 김유신인 데이터 조회 결과는 리스트
        System.out.println(resultList);
    }
    @Test
    public void test5(){
      List<Customer> list1 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(30)).fetch();
      List<Customer> list2 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(30)).fetch();
      List<Customer> list3 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.lt(30)).fetch();
      List<Customer> list4 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.loe(30)).fetch();
      List<Customer> list5 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.in(21,31,41)).fetch();


        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        System.out.println(list5);
    }

    @Test
    public void test6(){
        List<Customer> list = queryFactory.selectFrom(qCustomer)
                .where(qCustomer.age.like("%신"))
                .fetch();

        System.out.println(list);




    }
    @Test
    public void test7(){
        List<Product> list2 = queryFactory.selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.desc())
                .fetch();
        System.out.println(list2);
    }
    @Test
    public void test8(){
        List<Product> list = queryFactory
                .selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.asc())
                .offset(0)
                .limit(10)
                .fetch();
    }
    @Test
    public void test9(){

        ProductAggDTO resultDTO = new ProductAggDTO();
        queryFactory.select(
                        Projections.fields(
                                ProductAggDTO.class,
                                qProduct.price.sum().as("price_Sum"),
                                qProduct.price.avg().as("price_Avg"),
                                qProduct.price.max().as("price_Max"),
                                qProduct.price.min().as("price_Min")
                        )
                )
                .from(qProduct)
                .fetchOne();
        System.out.println(resultDTO);
    }
    @Test
    public void test10(){
       List<Customer> list =  queryFactory
                .select(Projections.fields(
                        Customer.class,
                        qOrder.customer.custId,
                        qOrder.customer.name,
                        qOrder.customer.custId.count().as("orderCount")
                ))
                .from(qOrder)
                .where(qOrder.orderStatus.eq(1)) // 1 - 주문완료 0 - 주문취소 등 필드값
                .groupBy(qOrder.customer.custId,
                        qOrder.customer.name)
                .having(qOrder.customer.custId.count().goe(2)) // 2건이상 카운트
                .fetch();

        System.out.println(list);
    }
    @Test
    public void test11(){ // 조인 해줘서 리스트에 뭘 뽑냐 ? = Tuple - 모르면 외워
       List<Tuple> list =  queryFactory
                .select(qOrder,qCustomer)
                .from(qOrder)
                .join(qCustomer)
                .on(qOrder.customer.eq(qCustomer))
                .fetch();
        System.out.println(list);
    }
    @Test // 동적쿼리 ?
    public void test12(){

        String name = null;
        Integer age = 21; // 나이가 21살 이상인? 애들만 검색

        // 동적 쿼리 생성 객체 (게시판 - 검색)
        BooleanBuilder builder = new BooleanBuilder();

        if(name != null){
            builder.and(qCustomer.name.eq(name));
        }
        if(age != null){
            builder.and(qCustomer.age.goe(age));
        }

       List<Customer> list = queryFactory
               .selectFrom(qCustomer)
               .where(builder) // 빌더에서 조건 추가 (동적쿼리)
               .fetch();
        System.out.println(list);
    }
    @Test
    public void test13(){}
    @Test
    public void test14(){}
    @Test
    public void test15(){}
}


