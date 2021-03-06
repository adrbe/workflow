package com.lwolf.wf.admin.rs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.lwolf.wf.dto.TaskDto;

public interface TaskResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskDto> listByProcess(
		@PathParam("processId") Integer processId
	);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{taskId}")
	public TaskDto read(
		@PathParam("processId") Integer processId,
		@PathParam("taskId") Integer taskId
	);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{taskId}")
	public TaskDto update(
		@Context HttpServletRequest request,
		@PathParam("processId") Integer processId,
		@PathParam("taskId") Integer taskId,
		TaskDto task
	);
	
	@DELETE
	@Path("{taskId}")
	public void delete(
		@PathParam("processId") Integer processId,
		@PathParam("taskId") Integer taskId
	);

}
