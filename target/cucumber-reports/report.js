$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/cucumberexample/login.feature");
formatter.feature({
  "name": "As an user I want login into Adayroi.com so that I can buy something in this website",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Show message with empty Email/Phone and password",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the login page is showed",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefs.the_login_page_is_showed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user provides his credential with emplty Email or Phone and password then try to login",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdefs.the_user_provides_his_credential_with_emplty_email_or_phone_and_password_then_try_to_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the message \"Chưa nhập email/số điện thoại\" and \"Chưa nhập mật khẩu\" will be showed",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefs.the_message_something_and_something_will_be_showed(String,String)"
});
formatter.result({
  "status": "passed"
});
});