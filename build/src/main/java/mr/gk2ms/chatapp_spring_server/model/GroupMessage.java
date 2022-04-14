package mr.gk2ms.chatapp_spring_server.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A Group Message
 */

@Schema(name = "GroupMessage", description = "A Group Message")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class GroupMessage extends RepresentationModel<GroupMessage>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private String id;

  @JsonProperty("text")
  private String text;

  @JsonProperty("dateSent")
  private BigDecimal dateSent;

  @JsonProperty("sender")
  private User sender;

  @JsonProperty("group")
  private Group group;

  public GroupMessage id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Group message identifier
   * @return id
  */
  
  @Schema(name = "id", description = "Group message identifier", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GroupMessage text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
  */
  
  @Schema(name = "text", required = false)
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public GroupMessage dateSent(BigDecimal dateSent) {
    this.dateSent = dateSent;
    return this;
  }

  /**
   * Get dateSent
   * @return dateSent
  */
  @Valid 
  @Schema(name = "dateSent", required = false)
  public BigDecimal getDateSent() {
    return dateSent;
  }

  public void setDateSent(BigDecimal dateSent) {
    this.dateSent = dateSent;
  }

  public GroupMessage sender(User sender) {
    this.sender = sender;
    return this;
  }

  /**
   * Get sender
   * @return sender
  */
  @Valid 
  @Schema(name = "sender", required = false)
  public User getSender() {
    return sender;
  }

  public void setSender(User sender) {
    this.sender = sender;
  }

  public GroupMessage group(Group group) {
    this.group = group;
    return this;
  }

  /**
   * Get group
   * @return group
  */
  @Valid 
  @Schema(name = "group", required = false)
  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupMessage groupMessage = (GroupMessage) o;
    return Objects.equals(this.id, groupMessage.id) &&
        Objects.equals(this.text, groupMessage.text) &&
        Objects.equals(this.dateSent, groupMessage.dateSent) &&
        Objects.equals(this.sender, groupMessage.sender) &&
        Objects.equals(this.group, groupMessage.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text, dateSent, sender, group);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupMessage {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    dateSent: ").append(toIndentedString(dateSent)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
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

