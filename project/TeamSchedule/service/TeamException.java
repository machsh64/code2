package project.TeamSchedule.service;

/**
 * @program: code
 * @author: Ren
 * @create: 2022-09-13 16:39
 * @description:
 **/
public class TeamException extends RuntimeException{

    static final long serialVersionUID = -7034897190745766939L;

    public TeamException(){

    }

    public TeamException(String msg){
        super(msg);
    }

}
