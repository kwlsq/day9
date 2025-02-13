package org.vincent.entity;

import java.util.UUID;

public class Task {
    private final UUID taskID;
    private final String taskName;
    private boolean isDone;

    public Task(String taskName, UUID taskID) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.isDone = false;
    }

    public String getTaskName(){
        return this.taskName;
    }

    public boolean getIsDone(){
        return this.isDone;
    }

    public void setIsDone(){
        this.isDone = true;
    }
}
