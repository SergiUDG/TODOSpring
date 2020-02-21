package org.udg.pds.springtodo.controller;

import io.minio.MinioClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.udg.pds.springtodo.Global;
import org.udg.pds.springtodo.controller.exceptions.ControllerException;

import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.UUID;

package org.udg.pds.springtodo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.udg.pds.springtodo.controller.exceptions.ControllerException;
import org.udg.pds.springtodo.entity.IdObject;
import org.udg.pds.springtodo.entity.Tag;
import org.udg.pds.springtodo.entity.Task;
import org.udg.pds.springtodo.entity.Views;
import org.udg.pds.springtodo.serializer.JsonDateDeserializer;
import org.udg.pds.springtodo.service.GroupService;
import org.udg.pds.springtodo.service.TaskService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@RequestMapping(path = "/groups")
@RestController
public class GroupController extends BaseController {

    @Autowired
    GroupService groupService;

    @PostMapping(consumes = "application/json")
    public IdObject addGroup(HttpSession session, @Valid @RequestBody GroupController.R_Group group) {

        Long userId = getLoggedUser(session);

        return GroupService.addGroup(group.name, group.description);
    }

    @PostMapping(path="/{gid}/members/´{uid}"){
        public IdObject addMember(HttpSession session, @Valid @RequestBody GroupController.R_Group group) {

            Long userId = getLoggedUser(session);

            return GroupService.addMember(group.name, group.description);
    }

    @PostMapping(path="/me/groups"){
            public IdObject showGroups(HttpSession session, @Valid @RequestBody GroupController.R_Group group) {

                Long userId = getLoggedUser(session);

                return GroupService.showGroups(group.name, group.description);
    }

    @PostMapping(path="/{gid}/members") {
            public IdObject showMembers(HttpSession session, @Valid @RequestBody GroupController.R_Group group) {

                Long userId = getLoggedUser(session);

                return GroupService.showGroups(group.name, group.description);
            }

    static class R_Group {
        @NotNull
        public String name;

        public String description;
    }

}
