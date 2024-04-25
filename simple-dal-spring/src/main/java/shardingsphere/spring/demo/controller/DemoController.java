package shardingsphere.spring.demo.controller;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shardingsphere.spring.demo.JaegerTracerHelper;
import shardingsphere.spring.demo.entity.Order;
import shardingsphere.spring.demo.mapper.OrderMapper;
import shardingsphere.spring.demo.service.TxService;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private static int a = 0;


    static {
        Tracer tracer = JaegerTracerHelper.initTracer("demoservice");
        GlobalTracer.registerIfAbsent(tracer);
    }

    @Autowired
    private OrderMapper orderMapper;


    @Autowired
    TxService txService;


    /**
     * 普通直接插入
     *
     * @return
     */
    @RequestMapping("/insert")
    public String insert() {
        Span span = GlobalTracer.get().buildSpan("demo").start();
        span.setBaggageItem("testdb", "1");
        GlobalTracer.get().activateSpan(span);
        try {
            Order order = new Order();
            order.setOrderId(a);
            order.setUserId(a);
            a++;
            orderMapper.insert(order);
        } catch (Throwable throwable) {
            span.finish();
        }
        return "OK";
    }

    /**
     * 普通读取
     *
     * @return
     */
    @RequestMapping("/read")
    public List<Order> read(@RequestParam("abc") String abc) {
        return orderMapper.findByUserId(Integer.valueOf(abc));
    }


    /**
     * 事物插入
     *
     * @return
     */
    @RequestMapping("/insertTx")
    public String insertTx() {
        txService.insert();
        return "OK";
    }

    /**
     * 内嵌事物插入
     *
     * @return
     */
    @RequestMapping("/insertNestedTx")
    public String insertTx2() {
        txService.insert2();
        return "OK";
    }


}
