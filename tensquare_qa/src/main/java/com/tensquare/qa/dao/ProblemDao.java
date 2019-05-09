package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;



/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
    /**
     * 最新回答列表
     * @return
     */
    @Query(value = "select * from tb_problem,tb_pl where id=problemid AND labelid=? ORDER BY replytime DESC",nativeQuery = true)
    public Page<Problem> newlist(String labelid, Pageable pageable);

    /**
     * 热门回答列表
     * @return
     */
    @Query(value = "select * from tb_problem,tb_pl where id=problemid AND labelid=? ORDER BY reply DESC",nativeQuery = true)
    public Page<Problem> hotlist(String labelid, Pageable pageable);

    /**
     * 等待回答列表
     * @return
     */
    @Query(value = "select * from tb_problem,tb_pl where id=problemid AND labelid=? and reply=0 ORDER BY createtime DESC",nativeQuery = true)
    public Page<Problem> waitlist(String labelid, Pageable pageable);
}
