package Team8.cafe_kiosk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private int phoneNumber;
    private int point;
    public Member(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
