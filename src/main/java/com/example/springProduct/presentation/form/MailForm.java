package com.example.springProduct.presentation.form;

import com.example.springProduct.domain.model.value.object.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@Data
public class MailForm {

    Mail mail;

    Address address;

    GenderEnum gender;

    Age age;

    OrganizationName organizationName;

    Id id;

    PhoneNumber phoneNumber;

    LocalDate birthDate;
}
