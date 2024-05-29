package Team8.cafe_kiosk.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    private Long memberId;
    private int phoneNumber;

    @Enumerated(EnumType.STRING)
    private RoleType role = RoleType.ROLE_CUSTOMER;
    public Member(int phoneNumber, RoleType role) {
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
