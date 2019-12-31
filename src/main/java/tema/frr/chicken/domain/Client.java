package tema.frr.chicken.domain;

import java.sql.Date;

public class Client {

  private String id;
  private String pwd;
  private String name;
  private Date birthday;
  private String sex;
  private String tel;
  private String address;
  private Date signUpDate;
  
  public String getId() {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Date getBirthday() {
    return birthday;
  }
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public Date getSignUpDate() {
    return signUpDate;
  }
  public void setSignUpDate(Date signUpDate) {
    this.signUpDate = signUpDate;
  }
}
