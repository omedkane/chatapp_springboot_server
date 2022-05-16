/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package mr.gk2ms.chatapp_spring_server.api;

import java.util.List;
import java.util.Optional;

import javax.annotation.Generated;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
import mr.gk2ms.chatapp_spring_server.model.UpdateGroupMembersRequest;
import mr.gk2ms.chatapp_spring_server.model.User;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "GroupMembers", description = "the GroupMembers API")
public interface GroupMembersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /groups/{groupId}/members : Manage group members
     * Add, remove, promote, demote members of group.
     *
     * @param groupId  (required)
     * @param updateGroupMembersRequest  (optional)
     * @return Group members updated successfully (status code 200)
     *         or Group not found (status code 404)
     */
    @Operation(
        operationId = "addMembers",
        summary = "Manage group members",
        tags = { "Group Members" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Group members updated successfully"),
            @ApiResponse(responseCode = "404", description = "Group not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/groups/{groupId}/members",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> addMembers(
        @Parameter(name = "groupId", description = "", required = true, schema = @Schema(description = "")) @PathVariable("groupId") String groupId,
        @Parameter(name = "UpdateGroupMembersRequest", description = "", schema = @Schema(description = "")) @Valid @RequestBody(required = false) UpdateGroupMembersRequest updateGroupMembersRequest
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /groups/{groupId}/members : Lists all group members
     * Lists all group members
     *
     * @param groupId  (required)
     * @return Group members fetched successfully (status code 200)
     */
    @Operation(
        operationId = "getGroupMembers",
        summary = "Lists all group members",
        tags = { "Group Members" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Group members fetched successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  User.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/groups/{groupId}/members",
        produces = { "application/json" }
    )
    default ResponseEntity<List<User>> getGroupMembers(
        @Parameter(name = "groupId", description = "", required = true, schema = @Schema(description = "")) @PathVariable("groupId") String groupId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"avatarURI\" : \"avatarURI\", \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"phone\" : \"phone\", \"id\" : \"id\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
