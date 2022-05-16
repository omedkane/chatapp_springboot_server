package mr.gk2ms.chatapp_spring_server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Add Group Members Request
 */

@Schema(name = "UpdateGroupMembersRequest", description = "Add Group Members Request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UpdateGroupMembersRequest extends RepresentationModel<UpdateGroupMembersRequest>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("targetMembers")
  @Valid
  private List<User> targetMembers = null;

  /**
   * Gets or Sets operation
   */
  public enum OperationEnum {
    ADD("add"),
    
    REMOVE("remove"),
    
    ADMINISTRATION("administration");
    
    private String value;

    OperationEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OperationEnum fromValue(String value) {
      for (OperationEnum b : OperationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("operation")
  private OperationEnum operation;

  public UpdateGroupMembersRequest targetMembers(List<User> targetMembers) {
    this.targetMembers = targetMembers;
    return this;
  }

  public UpdateGroupMembersRequest addTargetMembersItem(User targetMembersItem) {
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

  public UpdateGroupMembersRequest operation(OperationEnum operation) {
    this.operation = operation;
    return this;
  }

  /**
   * Get operation
   * @return operation
  */
  
  @Schema(name = "operation", required = false)
  public OperationEnum getOperation() {
    return operation;
  }

  public void setOperation(OperationEnum operation) {
    this.operation = operation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateGroupMembersRequest updateGroupMembersRequest = (UpdateGroupMembersRequest) o;
    return Objects.equals(this.targetMembers, updateGroupMembersRequest.targetMembers) &&
        Objects.equals(this.operation, updateGroupMembersRequest.operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetMembers, operation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateGroupMembersRequest {\n");
    sb.append("    targetMembers: ").append(toIndentedString(targetMembers)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
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

