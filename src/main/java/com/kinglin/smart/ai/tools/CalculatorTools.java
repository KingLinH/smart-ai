package com.kinglin.smart.ai.tools;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author HJinLin
 * @description 计算工具
 * @date 2025-06-21 2:01
 */
@Component
public class CalculatorTools {

    @Tool
    BigDecimal sum(BigDecimal a, BigDecimal b) {
        System.out.println("调用加法");
        return a.add(b);
    }

    @Tool
    BigDecimal squareRoot(BigDecimal x) {
        System.out.println("调用开平方");
        return BigDecimal.valueOf(Math.sqrt(x.doubleValue()));
    }

}
