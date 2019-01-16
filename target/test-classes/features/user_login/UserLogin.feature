Feature: Normal user login					
  
  Scenario: Login with empty username and empty password
    Given the user is on the login page
    When the user clicks the login button
    Then they should see the error message for username field
    
  Scenario: Login with correct username and empty password
    Given the user is on the login page
    When the user inputs his username as 'quyennt' 
    When the user clicks the login button
    Then they should see the error message for password field
    
 Scenario: Login with correct username and wrong password
    Given the user is on the login page
    When the user inputs his username as 'quyennt' 
    When the user inputs his password as 'abcdefgh'
    When the user clicks the login button
    Then they should see the error message 'Thông tin người dùng hoặc mật khẩu không hợp lệ'       
  
  Scenario: Login with correct username and correct password
    Given the user is on the login page
    When the user inputs his username as 'quyennt' 
    When the user inputs his password as 'Teko@123'
    When the user clicks the login button
    Then they should see the logout button
