package com.hackday.controller;

import com.hackday.constants.Controllers;
import com.hackday.entity.LessonEntity;
import com.hackday.entity.TaskEntity;
import com.hackday.results.TaskResult;
import com.hackday.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(Controllers.BASE_PATH + Controllers.TASK)
public class TaskController {
    @Autowired
    private TaskService service;


    @RequestMapping(value = Controllers.GET, method = RequestMethod.GET)
    public TaskEntity get(@RequestParam(value = Controllers.PARAM_ID) final Long id) throws IOException {
        return new TaskEntity();
    }

    @RequestMapping(value = Controllers.GET_LIST, method = RequestMethod.GET)
    public List<TaskEntity> getList(@RequestParam(value = Controllers.PARAM_LESSON_ID) final Long lessonID) throws IOException {
        return new ArrayList<>();
    }

    @RequestMapping(value = Controllers.TASK_SUBMIT, method = RequestMethod.GET)
    public TaskResult submit(@RequestParam(value = Controllers.PARAM_CODE) final String code,
                             @RequestParam(value = Controllers.PARAM_ID) final int taskID ) throws IOException {
        return service.submit(code, taskID);
    }

    @RequestMapping(value = Controllers.GET_MAP, method = RequestMethod.GET)
    public List<String> getMap(@RequestParam(value = Controllers.PARAM_ID) final int taskID) throws IOException {
        return service.getMap(taskID);
    }
}
