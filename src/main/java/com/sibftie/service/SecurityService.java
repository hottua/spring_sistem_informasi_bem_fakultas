package com.sibftie.service;


public interface SecurityService
{
    String findLoggedInUsername();

    void autologin(String email, String password);
}
