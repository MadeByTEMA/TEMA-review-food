package tema.frr.chicken.domain;

import java.io.Serializable;
import java.sql.Date;

public class Client implements Serializable {

  private static final long serialVersionUID = 20200207L;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
    result = prime * result + clientNo;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
    result = prime * result + ((sex == null) ? 0 : sex.hashCode());
    result = prime * result + ((signUpDate == null) ? 0 : signUpDate.hashCode());
    result = prime * result + ((tel == null) ? 0 : tel.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Client other = (Client) obj;
    if (address == null) {
      if (other.address != null) {
        return false;
      }
    } else if (!address.equals(other.address)) {
      return false;
    }
    if (birthday == null) {
      if (other.birthday != null) {
        return false;
      }
    } else if (!birthday.equals(other.birthday)) {
      return false;
    }
    if (clientNo != other.clientNo) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (pwd == null) {
      if (other.pwd != null) {
        return false;
      }
    } else if (!pwd.equals(other.pwd)) {
      return false;
    }
    if (sex == null) {
      if (other.sex != null) {
        return false;
      }
    } else if (!sex.equals(other.sex)) {
      return false;
    }
    if (signUpDate == null) {
      if (other.signUpDate != null) {
        return false;
      }
    } else if (!signUpDate.equals(other.signUpDate)) {
      return false;
    }
    if (tel == null) {
      if (other.tel != null) {
        return false;
      }
    } else if (!tel.equals(other.tel)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Client [clientNo=" + clientNo + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", birthday=" + birthday
        + ", sex=" + sex + ", tel=" + tel + ", address=" + address + ", signUpDate=" + signUpDate + "]";
  }

  private int clientNo;
  private String id;
  private String pwd;
  private String name;
  private Date birthday;
  private String sex;
  private String tel;
  private String address;
  private Date signUpDate;

  public int getClientNo() {
    return clientNo;
  }

  public void setClientNo(int clientNo) {
    this.clientNo = clientNo;
  }

  public String getId() {
    return id;
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

  public static Client valueOf(String csv) {
    String[] data = csv.split(",");

    Client client = new Client();
    client.setClientNo(Integer.parseInt(data[0]));
    client.setId(data[1]);
    client.setPwd(data[2]);
    client.setName(data[3]);
    client.setBirthday(Date.valueOf(data[4]));
    client.setSex(data[5]);
    client.setTel(data[6]);
    client.setAddress(data[7]);
    client.setSignUpDate(Date.valueOf(data[8]));

    return client;
  }

  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s\n",this.getClientNo(), this.getId(), this.getPwd(), this.getName(),
        this.getBirthday(), this.getSex(), this.getTel(), this.getAddress(), this.getSignUpDate());
  }
}
