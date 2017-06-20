package com.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Dto se koristi za slanje tog objekta prema forntendu, ili cega got drugoga koje koristi Rest servis za dohvat usera.
//znaci dto je razlicit od domenskog objekta (Users) po tome sto u sebi sadrzi objekte koji nemaju vezu nazat na ovaj
// objekt tako da se može serijalizirati u JSON format za potrebe REST-a
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UsersDto {

    private String username;
    private boolean enabled;
    private String email;
    private List<String> roles;
    private UserInfoDto userInfo;

}
