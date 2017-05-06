package mobsoft.vizelibalint.hu.mobszoftlab.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@ApiModel(description = "")
public class User extends SugarRecord {
  
  @SerializedName("userId")
  private Integer userId = null;
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("email")
  private String email = null;
  
  @SerializedName("password")
  private String password = null;
  
  @SerializedName("desk")
  private Desk desk = null;
  
  @SerializedName("seqNumber")
  private SeqNumber seqNumber = null;
  

public enum UserRoleEnum {
  @SerializedName("Client")
  CLIENT("Client"),

  @SerializedName("Worker")
  WORKER("Worker");

  private String value;

  UserRoleEnum(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

  @SerializedName("userRole")
  private UserRoleEnum userRole = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Desk getDesk() {
    return desk;
  }
  public void setDesk(Desk desk) {
    this.desk = desk;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public SeqNumber getSeqNumber() {
    return seqNumber;
  }
  public void setSeqNumber(SeqNumber seqNumber) {
    this.seqNumber = seqNumber;
  }

  
  /**
   * User role in the store.
   **/
  @ApiModelProperty(value = "User role in the store.")
  public UserRoleEnum getUserRole() {
    return userRole;
  }
  public void setUserRole(UserRoleEnum userRole) {
    this.userRole = userRole;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(userId, user.userId) &&
        Objects.equals(name, user.name) &&
        Objects.equals(email, user.email) &&
        Objects.equals(password, user.password) &&
        Objects.equals(desk, user.desk) &&
        Objects.equals(seqNumber, user.seqNumber) &&
        Objects.equals(userRole, user.userRole);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, email, password, desk, seqNumber, userRole);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    desk: ").append(toIndentedString(desk)).append("\n");
    sb.append("    seqNumber: ").append(toIndentedString(seqNumber)).append("\n");
    sb.append("    userRole: ").append(toIndentedString(userRole)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
