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
 * A Group Message
 */

@Schema(name = "Group", description = "A Group Message")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Group extends RepresentationModel<Group>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private String id;

  @JsonProperty("members")
  @Valid
  private List<User> members = null;

  @JsonProperty("creator")
  private User creator;

  @JsonProperty("messages")
  @Valid
  private List<GroupMessage> messages = null;

  @JsonProperty("administrator")
  private User administrator;

  public Group id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Group identifier
   * @return id
  */
  
  @Schema(name = "id", description = "Group identifier", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Group members(List<User> members) {
    this.members = members;
    return this;
  }

  public Group addMembersItem(User membersItem) {
    if (this.members == null) {
      this.members = new ArrayList<>();
    }
    this.members.add(membersItem);
    return this;
  }

  /**
   * Get members
   * @return members
  */
  @Valid 
  @Schema(name = "members", required = false)
  public List<User> getMembers() {
    return members;
  }

  public void setMembers(List<User> members) {
    this.members = members;
  }

  public Group creator(User creator) {
    this.creator = creator;
    return this;
  }

  /**
   * Get creator
   * @return creator
  */
  @Valid 
  @Schema(name = "creator", required = false)
  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }

  public Group messages(List<GroupMessage> messages) {
    this.messages = messages;
    return this;
  }

  public Group addMessagesItem(GroupMessage messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * Get messages
   * @return messages
  */
  @Valid 
  @Schema(name = "messages", required = false)
  public List<GroupMessage> getMessages() {
    return messages;
  }

  public void setMessages(List<GroupMessage> messages) {
    this.messages = messages;
  }

  public Group administrator(User administrator) {
    this.administrator = administrator;
    return this;
  }

  /**
   * Get administrator
   * @return administrator
  */
  @Valid 
  @Schema(name = "administrator", required = false)
  public User getAdministrator() {
    return administrator;
  }

  public void setAdministrator(User administrator) {
    this.administrator = administrator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(this.id, group.id) &&
        Objects.equals(this.members, group.members) &&
        Objects.equals(this.creator, group.creator) &&
        Objects.equals(this.messages, group.messages) &&
        Objects.equals(this.administrator, group.administrator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, members, creator, messages, administrator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    administrator: ").append(toIndentedString(administrator)).append("\n");
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

