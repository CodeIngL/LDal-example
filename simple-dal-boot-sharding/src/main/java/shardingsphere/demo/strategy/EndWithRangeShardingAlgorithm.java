package shardingsphere.demo.strategy;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashSet;


public class EndWithRangeShardingAlgorithm implements RangeShardingAlgorithm<Integer> {

    private final Logger logger = LoggerFactory.getLogger(RangeShardingAlgorithm.class);

    public EndWithRangeShardingAlgorithm() {
    }


    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Integer> shardingValue) {
        logger.info("Range collection:" + JSON.toJSONString(availableTargetNames) + ",rangeShardingValue:" + JSON.toJSONString(shardingValue));
        Collection<String> collect = new HashSet<>();
        Range<Integer> valueRange = shardingValue.getValueRange();
        for (Integer i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            for (String each : availableTargetNames) {
                if (each.endsWith(i % availableTargetNames.size() + "")) {
                    collect.add(each);
                }
            }
        }
        return collect;
//        return null;
    }

}
