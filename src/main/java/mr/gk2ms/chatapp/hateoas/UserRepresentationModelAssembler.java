package mr.gk2ms.chatapp.hateoas;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
// import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
// import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import mr.gk2ms.chatapp.controllers.UserController;
import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp_spring_server.model.User;

public class UserRepresentationModelAssembler extends RepresentationModelAssemblerSupport<UserEntity, User> {

	public UserRepresentationModelAssembler() {
		super(UserController.class, User.class);
	}

	public User toModel(UserEntity userEntity) {
		String id = Objects.nonNull(userEntity) ? userEntity.toString() : null;
		User resource = new User();

		resource.id(id);
		// resource.add(linkTo(methodOn(GroupController.class).))
		BeanUtils.copyProperties(userEntity, resource);

		return resource;
	}
}
