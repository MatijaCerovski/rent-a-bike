package com.rent.dto;

//Dto se koristi za slanje tog objekta prema forntendu, ili cega got drugoga koje koristi Rest servis za dohvat usera.
//znaci dto je razlicit od domenskog objekta (Users) po tome sto u sebi sadrzi objekte koji nemaju vezu nazat na ovaj
// objekt tako da se može serijalizirati u JSON format za potrebe REST-a
public class UsersDto {

    private int userId;
    private String username;
    private String password;
    private boolean enabled;
    private String email;
//    private List<UserRolesDto> userRoles; //za ovo nisam ni siguran da li bi vracali
//    private UserInfoDto userInfo;
//    private List<OrderDto> orders;

}
