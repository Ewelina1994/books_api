package pl.klobut.books_api.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@RequiredArgsConstructor
@Getter
@Setter
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
