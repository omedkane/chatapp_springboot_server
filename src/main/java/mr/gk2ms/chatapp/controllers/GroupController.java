package mr.gk2ms.chatapp.controllers;

import org.springframework.http.ResponseEntity;

import mr.gk2ms.chatapp.services.GroupService;
import mr.gk2ms.chatapp_spring_server.model.Group;
import mr.gk2ms.chatapp_spring_server.model.GroupCreationRequest;

public class GroupController {
	private GroupService service;

	public GroupController(GroupService service) {
		this.service = service;
	}

	public ResponseEntity<Group> create(GroupCreationRequest group) {

		return null;
	}

	public ResponseEntity<Group> read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<Void> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<Void> update(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
