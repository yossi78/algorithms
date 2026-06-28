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
        t.addTask(10,1);
        t.addTask(20,2);
        t.addTask(11,1);
        t.addTask(21,2);
        t.addTask(12,1);
        t.addTask(13,1);
        t.addTask(14,1);
        t.addTask(15,1);
        t.addTask(16,1);
        t.addTask(17,1);
        t.addTask(18,1);
        t.addTask(19,1);
        t.addTask(22,2);
        t.addTask(23,2);
        t.addTask(24,2);
        t.addTask(25,2);
        t.addTask(30,3);


        while(!t.pbq.isEmpty()) {
            Task task = t.getNextTask();
            System.out.println("next task = " + task.taskId);
            Thread.sleep(1000);
        }



    }




}
