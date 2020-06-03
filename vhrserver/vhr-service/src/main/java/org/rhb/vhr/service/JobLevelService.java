package org.rhb.vhr.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.mybatis.logging.LoggerFactory;
import org.rhb.vhr.mapper.JobLevelMapper;
import org.rhb.vhr.model.JobLevel;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class JobLevelService {
    /*public static final Logger logger = getLogger(JobLevelService.class);*/
    @Autowired
    JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAllJobLevel() {
        return jobLevelMapper.getAllJobLevel();
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.addJobLevel(jobLevel);
    }
    public Integer updateJobLevel(JobLevel jobLevel) {
        /*return jobLevelMapper.updateJobLevel(jobLevel);*/
        /*UpdateWrapper<JobLevel> jobLevelUpdateWrapper = new UpdateWrapper<>();*/
        return jobLevelMapper.updateById(jobLevel);

    }

    public Integer deleteJobLevelById(Integer id) {
       /* return jobLevelMapper.deleteJobLevelById(id);*/
        return jobLevelMapper.deleteById(id);
    }

    public Integer deletePositionByIds(Integer[] ids) {
       /* return jobLevelMapper.deleteJobLevelByIds(ids);*/
        return jobLevelMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
