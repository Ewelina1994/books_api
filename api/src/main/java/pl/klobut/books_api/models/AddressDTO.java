package pl.klobut.books_api.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDTO {
    private Long id;
    private String place;
    private String numberHome;
    private String street;
    private String numberFlat;
    private String postalCode;
}
