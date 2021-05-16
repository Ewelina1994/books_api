package pl.klobut.books_api.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressEntity extends BaseEntityWithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    @Column(name = "number_home")
    private String numberHome;
    private String street;
    @Column(name = "number_flat")
    private String numberFlat;
    private String postalCode;

}
