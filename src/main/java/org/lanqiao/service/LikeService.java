package org.lanqiao.service;

public interface LikeService {
    /**
     *
     * @param flag
     * @param uId
     * @param dId
     */
    int addOrCancelLike(String flag, int uId, int dId);
}
