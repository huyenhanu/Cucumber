Feature: As an user I want login into Adayroi.com so that I can buy something in this website

Scenario: Show message with empty Email or Phone
Given the login page is showed
When the user provides his credential with emplty "" or "" then try to login
Then the message "Số điện thoại hoặc email không chính xác" will be showed