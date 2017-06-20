package com.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class EmployersWrapperDto {

    List<UsersDto> employersList;
    List<UsersDto> othersList;
}
