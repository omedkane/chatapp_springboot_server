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
 * Deletes messages in a group or chat
 */

@Schema(name = "DeleteMessagesRequest", description = "Deletes messages in a group or chat")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class DeleteMessagesRequest extends RepresentationModel<DeleteMessagesRequest>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("messages")
  @Valid
  private List<String> messages = null;

  public DeleteMessagesRequest messages(List<String> messages) {
    this.messages = messages;
    return this;
  }

  public DeleteMessagesRequest addMessagesItem(String messagesItem) {
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
  
  @Schema(name = "messages", required = false)
  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteMessagesRequest deleteMessagesRequest = (DeleteMessagesRequest) o;
    return Objects.equals(this.messages, deleteMessagesRequest.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteMessagesRequest {\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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

