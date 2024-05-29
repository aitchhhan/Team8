package Team8.cafe_kiosk.domain;

import Team8.cafe_kiosk.service.ImageUtility;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Entity
@NoArgsConstructor
@Getter
public class Item {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;
    @Enumerated(EnumType.STRING)
    private Category category;

    // 이미지를 담는 byte 배열을 BLOB(Binary Large Object) 형식으로 저장
    @Lob
    @Column(name = "image", columnDefinition = "MEDIUMBLOB") // TINYBLOB: ~255Byte BLOB: ~64KB  MEDIUMBLOB: ~16MB LONGBLOB: ~4GB
    private byte[] image;
    public Item(Category category, String name, int price, byte[] image) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.image = image;
    }
    public String arrayToImage() {
        return ImageUtility.encodeImage(this.image);
    }

    public void setImage(MultipartFile image) throws IOException {
        this.image = image.getBytes();
    }
}
