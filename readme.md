### 1 数据库说明
- 配置表信息 config
  - id 主键，每个表都有一个主键 类型是 int
  - key_ 配置信息按照键值对的形式出现 ，类型是varchar(255)
  - value配置信息的值, 类型是 varchar(255)
- 消费分类表 category
  - id 主键，每个表都有一个主键 类型是 int
  - name分类的名称，类型是varchar(255)
- 消费记录表 record
  - id 主键，每个表都有一个主键 类型是 int
  - spend 本次花费，类型是int
  - cid 对应的消费分类表的中记录的id, 类型是int
  - comment 备注，比如分类是娱乐，但是你希望记录更详细的内容，啪啪啪，那么就存放在这里。
  - date 日期，本次记录发生的时间。
### 业务逻辑
1. 页面加载时跳转的首页是设置
    必须先设置本月预算 设置拦截器
### 使用到的技术
- 前端
  - JavaScript， layui···
- 后端
  - SSM java
### 后期改进加SpringBoot， mybatis-Plus 考虑改为前后端分离小项目（未完成）