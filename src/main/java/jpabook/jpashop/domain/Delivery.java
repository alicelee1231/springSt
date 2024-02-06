package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //ordinal로 쓰면 숫자로 들어감 -> 다른 상태가 생기면 오류
    //for example, if another number is made, like READY, xxx, COMP, it will be occurr ed a error, so it is better to use stirng
    private DeliveryStatus status; //READY, COMP



}
