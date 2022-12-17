package com.dc.contrlloer;

import com.dc.dal.HistorytradeInfoRepository;
import com.dc.dal.ScpoolRepository;
import com.dc.dal.StkdjRepository;
import com.dc.dal.StockCodeRepository;
import com.dc.multi.business.Strategy881Task;
import com.dc.multi.business.Strategy8888464Task;
import com.dc.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;


@RestController
@RequestMapping("batch8888464")
public class Batch8888464 {
    @Resource(name = "threadPoolInstance")
    private ExecutorService executorService;


    @Autowired
    private StockCodeRepository stockCodeRepository;

    @Autowired
    private ScpoolRepository scpoolRepository;

    @Autowired
    private StkdjRepository stkdjRepository;

    @Autowired
    private HistorytradeInfoRepository historytradeInfoRepository;

    @Autowired
    private Helper helper;


    @RequestMapping(value = "/recall8888464",method = RequestMethod.POST)
    public void recall881(String startDate,String endDate)
    {
        List<String> dateList= helper.findDaysStr(startDate,endDate);
        for (int i = 0; i < dateList.size(); i++) {
            Strategy8888464Task worker = new Strategy8888464Task(dateList.get(i), stockCodeRepository,  scpoolRepository,  stkdjRepository,  historytradeInfoRepository, helper);
            if (!executorService.isShutdown()){
                executorService.execute(worker);
            }
            executorService.shutdown();
        }

    }


}
