package pl.klobut.books_api.users;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
@RequiredArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private String numberHome;
    @Column(name = "number_home")
    private String street;
    @Column(name = "number_flat")
    private String numberFlat;
    private String postalCode;

}