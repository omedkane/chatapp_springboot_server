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

@Schema(name = "GroupCreationRequest", description = "Group creation request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class GroupCreationRequest extends RepresentationModel<GroupCreationRequest>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("creator")
  private String creator;

  public GroupCreationRequest name(String name) {
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

  public GroupCreationRequest creator(String creator) {
    this.creator = creator;
    return this;
  }

  /**
   * Get creator
   * @return creator
  */
  
  @Schema(name = "creator", required = false)
  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupCreationRequest groupCreationRequest = (GroupCreationRequest) o;
    return Objects.equals(this.name, groupCreationRequest.name) &&
        Objects.equals(this.creator, groupCreationRequest.creator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, creator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupCreationRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
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

