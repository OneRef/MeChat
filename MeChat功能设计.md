# MeChat设计

## 大致设计

### 频道功能由RabbitMQ实现

通过MySQL存储存储频道表，把频道分为好友类型和群聊类型，特色功能是消息可通过设置的方式设置存在时长

## 难点

后端接受到消息的时候需要反馈给前端

解决方式Websocket Netty RabbitMq