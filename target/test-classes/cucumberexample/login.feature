Feature: As an user I want login into Adayroi.com so that I can buy something in this website

Scenario: Show message with empty Email/Phone and password
Given the login page is showed
When the user provides his credential with emplty Email or Phone and password then try to login
Then the message "Chưa nhập email/số điện thoại" and "Chưa nhập mật khẩu" will be showed

