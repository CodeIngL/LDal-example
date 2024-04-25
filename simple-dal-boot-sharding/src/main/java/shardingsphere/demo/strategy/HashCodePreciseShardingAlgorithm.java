package shardingsphere.demo.strategy;

import com.alibaba.fastjson.JSON;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;


public class HashCodePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private final Logger logger = LoggerFactory.getLogger(HashCodePreciseShardingAlgorithm.class);

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        logger.info("availableTargetNames:" + JSON.toJSONString(availableTargetNames) + ",preciseShardingValue:" + JSON.toJSONString(shardingValue));
        //通过hashcode取模
        int num = (shardingValue.getValue() + "").hashCode() % availableTargetNames.size();
        String[] list = availableTargetNames.toArray(new String[availableTargetNames.size()]);
        if (num <= availableTargetNames.size()) {
            logger.info("return name:" + list[num]);
            return list[num];
        }
        return null;
    }
}
