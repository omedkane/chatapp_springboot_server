package mr.gk2ms.chatapp_spring_server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Add Group Members Request
 */

@Schema(name = "AddGroupMembersRequest", description = "Add Group Members Request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AddGroupMembersRequest extends RepresentationModel<AddGroupMembersRequest>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("targetMembers")
  @Valid
  private List<User> targetMembers = null;

  public AddGroupMembersRequest targetMembers(List<User> targetMembers) {
    this.targetMembers = targetMembers;
    return this;
  }

  public AddGroupMembersRequest addTargetMembersItem(User targetMembersItem) {
    if (this.targetMembers == null) {
      this.targetMembers = new ArrayList<>();
    }
    this.targetMembers.add(targetMembersItem);
    return this;
  }

  /**
   * Get targetMembers
   * @return targetMembers
  */
  @Valid 
  @Schema(name = "targetMembers", required = false)
  public List<User> getTargetMembers() {
    return targetMembers;
  }

  public void setTargetMembers(List<User> targetMembers) {
    this.targetMembers = targetMembers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddGroupMembersRequest addGroupMembersRequest = (AddGroupMembersRequest) o;
    return Objects.equals(this.targetMembers, addGroupMembersRequest.targetMembers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetMembers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddGroupMembersRequest {\n");
    sb.append("    targetMembers: ").append(toIndentedString(targetMembers)).append("\n");
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

