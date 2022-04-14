package mr.gk2ms.chatapp_spring_server.model;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Signed-in user information
 */

@Schema(name = "SignedInUser", description = "Signed-in user information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class SignedInUser extends RepresentationModel<SignedInUser>  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("refreshToken")
  private String refreshToken;

  @JsonProperty("accessToken")
  private String accessToken;

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("username")
  private String username;

  public SignedInUser refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Refresh Token, a unique secure string
   * @return refreshToken
  */
  
  @Schema(name = "refreshToken", description = "Refresh Token, a unique secure string", required = false)
  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public SignedInUser accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * JWT Token, aka accessToken
   * @return accessToken
  */
  
  @Schema(name = "accessToken", description = "JWT Token, aka accessToken", required = false)
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public SignedInUser userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * User identifier
   * @return userId
  */
  
  @Schema(name = "userId", description = "User identifier", required = false)
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public SignedInUser username(String username) {
    this.username = username;
    return this;
  }

  /**
   * User Name
   * @return username
  */
  
  @Schema(name = "username", description = "User Name", required = false)
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignedInUser signedInUser = (SignedInUser) o;
    return Objects.equals(this.refreshToken, signedInUser.refreshToken) &&
        Objects.equals(this.accessToken, signedInUser.accessToken) &&
        Objects.equals(this.userId, signedInUser.userId) &&
        Objects.equals(this.username, signedInUser.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refreshToken, accessToken, userId, username);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignedInUser {\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

