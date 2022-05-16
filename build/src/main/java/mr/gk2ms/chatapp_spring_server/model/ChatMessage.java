package mr.gk2ms.chatapp_spring_server.model;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * A Chat Message
 */

@Schema(name = "ChatMessage", description = "A Chat Message")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ChatMessage extends RepresentationModel<ChatMessage>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private String id;

  @JsonProperty("text")
  private String text;

  @JsonProperty("sender")
  private User sender;

  @JsonProperty("dateSent")
  private Integer dateSent;

  @JsonProperty("chat")
  private Chat chat;

  public ChatMessage id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Chat message identifier
   * @return id
  */
  
  @Schema(name = "id", description = "Chat message identifier", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ChatMessage text(String text) {
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

  public ChatMessage sender(User sender) {
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

  public ChatMessage dateSent(Integer dateSent) {
    this.dateSent = dateSent;
    return this;
  }

  /**
   * Get dateSent
   * @return dateSent
  */
  
  @Schema(name = "dateSent", required = false)
  public Integer getDateSent() {
    return dateSent;
  }

  public void setDateSent(Integer dateSent) {
    this.dateSent = dateSent;
  }

  public ChatMessage chat(Chat chat) {
    this.chat = chat;
    return this;
  }

  /**
   * Get chat
   * @return chat
  */
  @Valid 
  @Schema(name = "chat", required = false)
  public Chat getChat() {
    return chat;
  }

  public void setChat(Chat chat) {
    this.chat = chat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChatMessage chatMessage = (ChatMessage) o;
    return Objects.equals(this.id, chatMessage.id) &&
        Objects.equals(this.text, chatMessage.text) &&
        Objects.equals(this.sender, chatMessage.sender) &&
        Objects.equals(this.dateSent, chatMessage.dateSent) &&
        Objects.equals(this.chat, chatMessage.chat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text, sender, dateSent, chat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatMessage {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
    sb.append("    dateSent: ").append(toIndentedString(dateSent)).append("\n");
    sb.append("    chat: ").append(toIndentedString(chat)).append("\n");
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

