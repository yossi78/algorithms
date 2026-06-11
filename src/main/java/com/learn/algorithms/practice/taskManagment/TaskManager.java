package com.learn.algorithms.practice.taskManagment;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;


public class TaskManager {


    private Map<Integer,Task> taskMap = new ConcurrentHashMap<>();
    private PriorityBlockingQueue<Task>  pbq = new PriorityBlockingQueue<>();


    public void addTask(int taskId, int priority){
        Task task  = new Task(taskId,priority);
        pbq.add(task);
        this.taskMap.put(taskId,task);
    }


    public Task getNextTask(){
        Task task  =  pbq.poll();
        if(task!=null && this.taskMap.containsKey( task.taskId)){
            this.taskMap.remove(task);
        }
        return task;
    }

    public static void main(String[] args) throws InterruptedException {
        TaskManager t = new TaskManager();
        t.addTask(33,1);
        t.addTask(40,2);
        t.addTask(11,1);
        t.addTask(20,2);
        t.addTask(22,1);
        t.addTask(60,2);


        for(int i=0;i<6;i++) {
            Task task = t.getNextTask();
            System.out.println("next task = " + task.taskId);
            Thread.sleep(1000);
        }


    }




}
