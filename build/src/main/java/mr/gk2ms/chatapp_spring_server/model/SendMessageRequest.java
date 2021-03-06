package mr.gk2ms.chatapp_spring_server.model;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Send Message Request
 */

@Schema(name = "SendMessageRequest", description = "Send Message Request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class SendMessageRequest extends RepresentationModel<SendMessageRequest>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("message")
  private String message;

  @JsonProperty("target")
  private String target;

  public SendMessageRequest message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  
  @Schema(name = "message", required = false)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public SendMessageRequest target(String target) {
    this.target = target;
    return this;
  }

  /**
   * Get target
   * @return target
  */
  
  @Schema(name = "target", required = false)
  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMessageRequest sendMessageRequest = (SendMessageRequest) o;
    return Objects.equals(this.message, sendMessageRequest.message) &&
        Objects.equals(this.target, sendMessageRequest.target);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, target);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMessageRequest {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
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

