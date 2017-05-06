package mobsoft.vizelibalint.hu.mobszoftlab.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@ApiModel(description = "")
public class Desk extends SugarRecord {
  
  @SerializedName("deskId")
  private Integer deskId = null;
  
  @SerializedName("activeState")
  private Boolean activeState = null;
  
  @SerializedName("actualSeqNumber")
  private SeqNumber actualSeqNumber = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getDeskId() {
    return deskId;
  }
  public void setDeskId(Integer deskId) {
    this.deskId = deskId;
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

  
  /**
   **/
  @ApiModelProperty(value = "")
  public SeqNumber getActualSeqNumber() {
    return actualSeqNumber;
  }
  public void setActualSeqNumber(SeqNumber actualSeqNumber) {
    this.actualSeqNumber = actualSeqNumber;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Desk desk = (Desk) o;
    return Objects.equals(deskId, desk.deskId) &&
        Objects.equals(activeState, desk.activeState) &&
        Objects.equals(actualSeqNumber, desk.actualSeqNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deskId, activeState, actualSeqNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Desk {\n");
    
    sb.append("    deskId: ").append(toIndentedString(deskId)).append("\n");
    sb.append("    activeState: ").append(toIndentedString(activeState)).append("\n");
    sb.append("    actualSeqNumber: ").append(toIndentedString(actualSeqNumber)).append("\n");
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
