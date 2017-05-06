package mobsoft.vizelibalint.hu.mobszoftlab.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@ApiModel(description = "")
public class DeskCategory extends SugarRecord {
  
  @SerializedName("deskCategoryId")
  private Integer deskCategoryId = null;
  
  @SerializedName("category")
  private Category category = null;
  
  @SerializedName("desk")
  private Desk desk = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getDeskCategoryId() {
    return deskCategoryId;
  }
  public void setDeskCategoryId(Integer deskCategoryId) {
    this.deskCategoryId = deskCategoryId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Category getCategory() {
    return category;
  }
  public void setCategory(Category category) {
    this.category = category;
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

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeskCategory deskCategory = (DeskCategory) o;
    return Objects.equals(deskCategoryId, deskCategory.deskCategoryId) &&
        Objects.equals(category, deskCategory.category) &&
        Objects.equals(desk, deskCategory.desk);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deskCategoryId, category, desk);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeskCategory {\n");
    
    sb.append("    deskCategoryId: ").append(toIndentedString(deskCategoryId)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    desk: ").append(toIndentedString(desk)).append("\n");
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
