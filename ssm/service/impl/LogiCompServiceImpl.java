package ssm.service.impl;
import ssm.dao.LogiCompDao;
import ssm.service.LogiCompService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import ssm.model.LogiComp;


@Service
public class LogiCompServiceImpl implements LogiCompService {
    @Resource LogiCompDao logiCompDao;
}
