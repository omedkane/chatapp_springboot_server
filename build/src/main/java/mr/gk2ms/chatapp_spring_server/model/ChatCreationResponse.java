package mr.gk2ms.chatapp_spring_server.model;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Successful chat creation response
 */

@Schema(name = "ChatCreationResponse", description = "Successful chat creation response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ChatCreationResponse extends RepresentationModel<ChatCreationResponse>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("chatId")
  private String chatId;

  public ChatCreationResponse chatId(String chatId) {
    this.chatId = chatId;
    return this;
  }

  /**
   * Get chatId
   * @return chatId
  */
  
  @Schema(name = "chatId", required = false)
  public String getChatId() {
    return chatId;
  }

  public void setChatId(String chatId) {
    this.chatId = chatId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChatCreationResponse chatCreationResponse = (ChatCreationResponse) o;
    return Objects.equals(this.chatId, chatCreationResponse.chatId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chatId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChatCreationResponse {\n");
    sb.append("    chatId: ").append(toIndentedString(chatId)).append("\n");
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

