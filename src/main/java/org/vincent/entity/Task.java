package org.vincent.entity;

import java.util.UUID;

public class Task {
    private final UUID taskID;
    private final String taskName;
    private boolean isDone;

    public Task(String taskName) {
        this.taskID = UUID.randomUUID();
        this.taskName = taskName;
        this.isDone = false;
    }

    public UUID getTaskID(){
        return this.taskID;
    }

    public String getTaskName(){
        return this.taskName;
    }

    public boolean getIsDone(){
        return this.isDone;
    }
}
