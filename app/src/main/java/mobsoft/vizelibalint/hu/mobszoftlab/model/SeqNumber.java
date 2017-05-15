package mobsoft.vizelibalint.hu.mobszoftlab.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@ApiModel(description = "")
public class SeqNumber extends SugarRecord implements Serializable{
  
  @SerializedName("number")
  private Integer number = null;
  
  @SerializedName("activeState")
  private Boolean activeState = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getNumber() {
    return number;
  }
  public void setNumber(Integer number) {
    this.number = number;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Boolean getActiveState() {
    return activeState;
  }
  public void setActiveState(Boolean activeState) {
    this.activeState = activeState;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SeqNumber seqNumber = (SeqNumber) o;
    return Objects.equals(number, seqNumber.number) &&
        Objects.equals(activeState, seqNumber.activeState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, activeState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeqNumber {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    activeState: ").append(toIndentedString(activeState)).append("\n");
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
