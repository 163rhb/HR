package org.rhb.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.rhb.vhr.model.JobLevel;


import java.util.List;

public interface JobLevelMapper  extends BaseMapper<JobLevel> {
    List<JobLevel> getAllJobLevel();

    Integer addJobLevel(JobLevel jobLevel);

    Integer updateJobLevel(JobLevel jobLevel);

    Integer deleteJobLevelById(Integer id);

    Integer deleteJobLevelByIds(@Param("ids") Integer[] ids);
}
