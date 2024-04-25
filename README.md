# notice

simple-dal提供LDal框架下的简单的spring以及springboot例子。

分别是

1. 双写
2. 禁写
3. 主写
4. mq双写
5. 只读
6. 基于权重的只读
7. 影子库灰度
8. 分库分表
9. spring例子


## LDal是什么

LDal是一个基于mybaits框架，支持业务方无风险的引入其他同构以及异构数据库，并帮助迁移数据，验证性能，同时100%保证异构数据库之间最终一致性

特别适合金融行业核心业务引入信创数据库:tidb,oceanbase,达梦其他等等以及去Oracle

## 运行要求

### 安装依赖

1. 确保依赖存在

    ```xml
            <dependency>
                <groupId>com.codeL.data</groupId>
                <artifactId>data-dal-spring</artifactId>
                <version>1.0.0-SNAPSHOT</version>
            </dependency>
            <dependency>
                <groupId>com.codeL.data</groupId>
                <artifactId>data-dal-spring-starter</artifactId>
                <version>1.0.0-SNAPSHOT</version>
            </dependency>
    ```
2. 运行于localhost:3306的mysql实例
    - 用户名:root
    - 密码:123456
3. 执行db/data.sql文件
4. 运行工程中任意例子



