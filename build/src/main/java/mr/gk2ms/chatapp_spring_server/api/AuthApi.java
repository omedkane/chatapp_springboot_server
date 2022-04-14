/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package mr.gk2ms.chatapp_spring_server.api;

import java.util.Optional;

import javax.annotation.Generated;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import mr.gk2ms.chatapp_spring_server.model.RefreshToken;
import mr.gk2ms.chatapp_spring_server.model.SignInRequest;
import mr.gk2ms.chatapp_spring_server.model.SignedInUser;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "Auth", description = "the Auth API")
public interface AuthApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /auth/token/refresh : Provides new JWT based on valid refresh token
     * Provides new JWT based on valid refresh token
     *
     * @param refreshToken  (optional)
     * @return JWT successfully provided (status code 200)
     */
    @Operation(
        operationId = "refreshToken",
        summary = "Provides new JWT based on valid refresh token",
        tags = { "Auth" },
        responses = {
            @ApiResponse(responseCode = "200", description = "JWT successfully provided", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  SignedInUser.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/token/refresh",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<SignedInUser> refreshToken(
        @Parameter(name = "RefreshToken", description = "", schema = @Schema(description = "")) @Valid @RequestBody(required = false) RefreshToken refreshToken
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"accessToken\" : \"accessToken\", \"userId\" : \"userId\", \"refreshToken\" : \"refreshToken\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /auth/signin : Signs user in
     * Signs user in
     *
     * @param signInRequest  (optional)
     * @return User successfully signed-in (status code 201)
     */
    @Operation(
        operationId = "signIn",
        summary = "Signs user in",
        tags = { "Auth" },
        responses = {
            @ApiResponse(responseCode = "201", description = "User successfully signed-in", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  SignedInUser.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/signin",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<SignedInUser> signIn(
        @Parameter(name = "SignInRequest", description = "", schema = @Schema(description = "")) @Valid @RequestBody(required = false) SignInRequest signInRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"accessToken\" : \"accessToken\", \"userId\" : \"userId\", \"refreshToken\" : \"refreshToken\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /auth/signout : Signs user out
     * Signs user out
     *
     * @param refreshToken  (optional)
     * @return Accepts the request for logout (status code 202)
     */
    @Operation(
        operationId = "signOut",
        summary = "Signs user out",
        tags = { "Auth" },
        responses = {
            @ApiResponse(responseCode = "202", description = "Accepts the request for logout")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/auth/signout",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> signOut(
        @Parameter(name = "RefreshToken", description = "", schema = @Schema(description = "")) @Valid @RequestBody(required = false) RefreshToken refreshToken
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
