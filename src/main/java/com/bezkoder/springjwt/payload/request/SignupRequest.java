package com.bezkoder.springjwt.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank(message = "Thông tin đăng nhập không có tên tài khoản")
    @Size(min = 3, max = 20, message = "Username phải có độ dài từ 3 đến 20")
    private String username;
 
    @NotBlank(message = "Thông tin đăng nhập không có email")
    @Size(max = 50, message = "Email quá dài")
    @Email(message = "Địa chỉ email không hợp lệ")
    private String email;
    
    private Set<String> role;
    
    @NotBlank(message = "Thông tin đăng nhập không có mật khẩu")
    @Size(min = 6, max = 40, message = "Username phải có độ dài từ 6 đến 40")
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
