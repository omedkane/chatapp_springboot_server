package mr.gk2ms.chatapp_spring_server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A Chat
 */

@Schema(name = "Chat", description = "A Chat")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Chat extends RepresentationModel<Chat>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private String id;

  @JsonProperty("recipientA")
  private User recipientA;

  @JsonProperty("recipientB")
  private User recipientB;

  @JsonProperty("messages")
  @Valid
  private List<ChatMessage> messages = null;

  @JsonProperty("dateCreated")
  private int dateCreated;

  public Chat id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Chat identifier
   * @return id
  */
  
  @Schema(name = "id", description = "Chat identifier", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Chat recipientA(User recipientA) {
    this.recipientA = recipientA;
    return this;
  }

  /**
   * Get recipientA
   * @return recipientA
  */
  @Valid 
  @Schema(name = "recipientA", required = false)
  public User getRecipientA() {
    return recipientA;
  }

  public void setRecipientA(User recipientA) {
    this.recipientA = recipientA;
  }

  public Chat recipientB(User recipientB) {
    this.recipientB = recipientB;
    return this;
  }

  /**
   * Get recipientB
   * @return recipientB
  */
  @Valid 
  @Schema(name = "recipientB", required = false)
  public User getRecipientB() {
    return recipientB;
  }

  public void setRecipientB(User recipientB) {
    this.recipientB = recipientB;
  }

  public Chat messages(List<ChatMessage> messages) {
    this.messages = messages;
    return this;
  }

  public Chat addMessagesItem(ChatMessage messagesItem) {
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
  public List<ChatMessage> getMessages() {
    return messages;
  }

  public void setMessages(List<ChatMessage> messages) {
    this.messages = messages;
  }

  public Chat dateCreated(int dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

  /**
   * Get dateCreated
   * @return dateCreated
  */
  @Valid 
  @Schema(name = "dateCreated", required = false)
  public int getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(int dateCreated) {
    this.dateCreated = dateCreated;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Chat chat = (Chat) o;
    return Objects.equals(this.id, chat.id) &&
        Objects.equals(this.recipientA, chat.recipientA) &&
        Objects.equals(this.recipientB, chat.recipientB) &&
        Objects.equals(this.messages, chat.messages) &&
        Objects.equals(this.dateCreated, chat.dateCreated);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, recipientA, recipientB, messages, dateCreated);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Chat {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    recipientA: ").append(toIndentedString(recipientA)).append("\n");
    sb.append("    recipientB: ").append(toIndentedString(recipientB)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
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

