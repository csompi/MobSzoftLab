package mobsoft.vizelibalint.hu.mobszoftlab.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@ApiModel(description = "")
public class Category extends SugarRecord implements Serializable {
  
  @SerializedName("categoryId")
  private Integer categoryId = null;
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("enabled")
  private Boolean enabled = null;
  
  @SerializedName("seqNumbers")
  private List<SeqNumber> seqNumbers = new ArrayList<SeqNumber>();
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
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
  public Boolean getEnabled() {
    return enabled;
  }
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<SeqNumber> getSeqNumbers() {
    return seqNumbers;
  }
  public void setSeqNumbers(List<SeqNumber> seqNumbers) {
    this.seqNumbers = seqNumbers;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(categoryId, category.categoryId) &&
        Objects.equals(name, category.name) &&
        Objects.equals(enabled, category.enabled) &&
        Objects.equals(seqNumbers, category.seqNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, name, enabled, seqNumbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    seqNumbers: ").append(toIndentedString(seqNumbers)).append("\n");
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
