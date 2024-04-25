package data.dal.example.controller;

import data.dal.example.JaegerTracerHelper;
import data.dal.example.entity.Order;
import data.dal.example.mapper.OrderMapper;
import data.dal.example.service.TxService;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shadow")
public class ShadowController {

    private static int a = 0;


    static {
        Tracer tracer = JaegerTracerHelper.initTracer("demoservice");
        GlobalTracer.registerIfAbsent(tracer);
    }

    @Autowired
    private OrderMapper orderMapper;


    @Autowired
    TxService txService;


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

}
