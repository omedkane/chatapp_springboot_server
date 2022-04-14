package mr.gk2ms.chatapp_spring_server.model;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Sign-in request
 */

@Schema(name = "SignInRequest", description = "Sign-in request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class SignInRequest extends RepresentationModel<SignInRequest>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  public SignInRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * User email
   * @return email
  */
  
  @Schema(name = "email", description = "User email", required = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SignInRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * User password
   * @return password
  */
  
  @Schema(name = "password", description = "User password", required = false)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignInRequest signInRequest = (SignInRequest) o;
    return Objects.equals(this.email, signInRequest.email) &&
        Objects.equals(this.password, signInRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignInRequest {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

