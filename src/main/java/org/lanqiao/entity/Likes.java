package org.lanqiao.entity;

import java.util.Date;

public class Likes {
    private int u_id;
    private int d_id;
    private Date like_time;

    public Likes(){};

    public Likes(int u_id, int d_id) {
        this.u_id = u_id;
        this.d_id = d_id;
    }

    public Likes(int u_id, int d_id, Date like_time) {
        this.u_id = u_id;
        this.d_id = d_id;
        this.like_time = like_time;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public Date getLike_time() {
        return like_time;
    }

    public void setLike_time(Date like_time) {
        this.like_time = like_time;
    }
}
