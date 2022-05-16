package mr.gk2ms.chatapp_spring_server.model;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Group creation request
 */

@Schema(name = "GroupUpdateRequest", description = "Group creation request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class GroupUpdateRequest extends RepresentationModel<GroupUpdateRequest>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  public GroupUpdateRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupUpdateRequest groupUpdateRequest = (GroupUpdateRequest) o;
    return Objects.equals(this.name, groupUpdateRequest.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupUpdateRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

